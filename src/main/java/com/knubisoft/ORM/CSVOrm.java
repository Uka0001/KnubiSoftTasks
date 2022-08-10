package com.knubisoft.ORM;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVOrm {

    public static final String DELIMITER = ",";
    public static final String COMMENT = "--";

    public static <T> List<T> transform(List<String> lines, Class<T> cls) {
        Map<Integer, String> mapping = buildMapping(lines.get(0));

        return lines.subList(1, lines.size()).stream().map(line -> toType(line, cls, mapping))
                .collect(Collectors.toList());
    }

    private static Map<Integer, String> buildMapping(String firstLine) {
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

    @SneakyThrows
    private static <T> T toType(String line, Class<T> cls, Map<Integer, String> mapping) {
        T type = cls.getDeclaredConstructor().newInstance();

        String[] array = splitLine(line);
        for (int index = 0; index < array.length; index++) {
            String value = array[index];
            String fieldName = mapping.get(index);
            setValueIntoFieldOrThrow(value, fieldName, type);
        }

        return type;
    }

    private static void setValueIntoFieldOrThrow(String value, String fieldName, Object type) {
        try {
            Field field = type.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(type, transformValueToFieldType(field, value));
        } catch (NoSuchFieldException noField) {
            // ignore
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    private static String[] splitLine(String line) {
        return line.split(DELIMITER);
    }

}
