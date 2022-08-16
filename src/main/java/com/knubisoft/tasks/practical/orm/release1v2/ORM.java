package com.knubisoft.tasks.practical.orm.release1v2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

public class ORM implements ORMInterface {

    @Override
    @SneakyThrows
    public <T> List<T> transform(DataInputSource inputSource, Class<T> cls) {
        Table table = convertToTable(inputSource);
        return convertTableToListOfClasses(table, cls);
    }

    private <T> List<T> convertTableToListOfClasses(Table table, Class<T> cls) {
        List<T> result = new ArrayList<>();
        for (int index = 0; index < table.size(); index++) {
            Map<String, String> row = table.getTableRowByIndex(index);
            T instance = reflectTableRowToClass(row, cls);
            result.add(instance);
        }
        return result;
    }

    @SneakyThrows
    private <T> T reflectTableRowToClass(Map<String, String> row, Class<T> cls) {
        T instance = cls.getDeclaredConstructor().newInstance();
        for (Field each : cls.getDeclaredFields()) {
            each.setAccessible(true);
            String value = row.get(each.getName());
            if (value != null) {
                each.set(instance, transformValueToFieldType(each, value));
            }
        }
        return instance;
    }

    private static Object transformValueToFieldType(Field field, String value) {
        Map<Class<?>, Function<String, Object>> typeToFunction = new LinkedHashMap<>();
        typeToFunction.put(String.class, s -> s);
        typeToFunction.put(int.class, Integer::parseInt);
        typeToFunction.put(Float.class, Float::parseFloat);
        typeToFunction.put(LocalDate.class, LocalDate::parse);
        typeToFunction.put(LocalDateTime.class, LocalDate::parse);
        typeToFunction.put(Long.class, Long::parseLong);
        typeToFunction.put(BigInteger.class, BigInteger::new);

        return typeToFunction.getOrDefault(field.getType(), type -> {
            throw new UnsupportedOperationException("Type is not supported by parser " + type);
        }).apply(value);
    }

    private Table convertToTable(DataInputSource dataInputSource) {
        if (dataInputSource instanceof DatabaseInputSource) {
            return new DatabaseParsingStrategy().
                    parseToTable((DatabaseInputSource) dataInputSource);
        } else if (dataInputSource instanceof StringInputSource) {
            return getStringParsingStrategy((StringInputSource) dataInputSource).
                    parseToTable((StringInputSource) dataInputSource);
        } else {
            throw new UnsupportedOperationException("Unknown DataInputSource " + dataInputSource);
        }
    }

    private ParsingStrategy<StringInputSource> getStringParsingStrategy(StringInputSource inputSource) {
        String content = inputSource.getContent();
        char firstChar = content.charAt(0);
        switch (firstChar) {
            case '{':
            case '[':
                return new JSONParsingStrategy();
            case '<':
                return new XMLParsingStrategy();
            default:
                return new CSVParsingStrategy();
        }
    }

    interface ParsingStrategy<T extends DataInputSource> {
        Table parseToTable(T content);
    }

    static class XMLParsingStrategy implements ParsingStrategy<StringInputSource> {
        @SneakyThrows
        @Override
        public Table parseToTable(StringInputSource content) {
            XmlMapper mapper = new XmlMapper();
            JsonNode result = mapper.readTree(content.getContent());
            return null;
        }
    }

    static class JSONParsingStrategy implements ParsingStrategy<StringInputSource> {

        @SneakyThrows
        @Override
        public Table parseToTable(StringInputSource content) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode tree = mapper.readTree(content.getContent());
            Map<Integer, Map<String, String>> result = buildTable(tree);
            return new Table(result);
        }

        private Map<Integer, Map<String, String>> buildTable(JsonNode tree) {
            Map<Integer, Map<String, String>> map = new LinkedHashMap<>();
            int index = 0;
            for (JsonNode each : tree) {
                Map<String, String> item = buildRow(each);
                map.put(index, item);
                index++;
            }
            return map;
        }

        private Map<String, String> buildRow(JsonNode each) {
            Map<String, String> item = new LinkedHashMap<>();
            Iterator<Map.Entry<String, JsonNode>> itr = each.fields();
            while (itr.hasNext()) {
                Map.Entry<String, JsonNode> next = itr.next();
                item.put(next.getKey(), next.getValue().textValue());
            }
            return item;
        }

    }

    static class CSVParsingStrategy implements ParsingStrategy<StringInputSource> {

        public static final String DELIMITER = ",";
        public static final String COMMENT = "--";

        @Override
        public Table parseToTable(StringInputSource content) {
            List<String> lines = Arrays.asList(content.getContent().split(System.lineSeparator()));
            Map<Integer, String> mapping = buildMapping(lines.get(0));
            Map<Integer, Map<String, String>> result = buildTable(lines.subList(1, lines.size()), mapping);
            return new Table(result);
        }

        private Map<Integer, Map<String, String>> buildTable(List<String> lines, Map<Integer, String> mapping) {
            Map<Integer, Map<String, String>> result = new LinkedHashMap<>();
            for (int index = 0; index < lines.size(); index++) {
                String line = lines.get(index);
                result.put(index, buildRow(mapping, line));
            }
            return result;
        }

        private Map<String, String> buildRow(Map<Integer, String> mapping, String line) {
            Map<String, String> nameToValueMap = new LinkedHashMap<>();
            String[] rowItems = splitLine(line);
            for (int rowIndex = 0; rowIndex < rowItems.length; rowIndex++) {
                String value = rowItems[rowIndex];
                nameToValueMap.put(mapping.get(rowIndex), value);
            }
            return nameToValueMap;
        }

        private Map<Integer, String> buildMapping(String firstLine) {
            Map<Integer, String> map = new LinkedHashMap<>();
            String[] array = splitLine(firstLine);
            for (int index = 0; index < array.length; index++) {
                String value = array[index];
                if (value.contains(COMMENT)) {
                    value = value.split(COMMENT)[0];
                }
                map.put(index, value.trim());
            }
            return map;
        }

        private static String[] splitLine(String line) {
            return line.split(DELIMITER);
        }
    }

    static class DatabaseParsingStrategy implements ParsingStrategy<DatabaseInputSource> {

        @Override
        public Table parseToTable(DatabaseInputSource content) {
            ResultSet rs = content.getResultSet();
            Map<Integer, Map<String, String>> result = buildTable(rs);
            return new Table(result);
        }

        @SneakyThrows
        private Map<Integer, Map<String, String>> buildTable(ResultSet rs) {
            ResultSetMetaData metadata = rs.getMetaData();

            Map<Integer, Map<String, String>> result = new LinkedHashMap<>();
            int rowId = 0;
            while (rs.next()) {
                Map<String, String> row = new LinkedHashMap<>();
                for (int index = 0; index < metadata.getColumnCount(); index++) {
                    row.put(metadata.getColumnName(index), rs.getString(index));
                }
                result.put(rowId, row);
                rowId++;
            }

            return result;
        }
    }

    @RequiredArgsConstructor
    static class Table {

        private final Map<Integer, Map<String, String>> table;

        public String getCell(int row, String columnName) {
            Map<String, String> nameToCell = table.get(row);
            if (nameToCell != null) {
                return nameToCell.get(columnName);
            }
            return null;
        }

        int size() {
            return table.size();
        }

        Map<String, String> getTableRowByIndex(int row) {
            Map<String, String> result = table.get(row);
            return result == null ? null : new LinkedHashMap<>(result);
        }

    }


}
