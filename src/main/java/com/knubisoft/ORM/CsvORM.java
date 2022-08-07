package com.knubisoft.ORM;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvORM {

    public static final String DELIMITER = ",";
    public static final String COMMENT = "--";

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

    private static String[] splitLine(String line) {
        return line.split(DELIMITER);
    }

    public static List<Person> transform(List<String> lines) {
        Map<Integer, String> mapping = buildMapping(lines.get(0));
        return lines.subList(1, lines.size()).stream().map(line ->
                        toPerson(line, mapping))
                .collect(Collectors.toList());
    }

    private static Person toPerson(String line, Map<Integer, String> mapping) {
        Person person = new Person();

        String[] array = line.split(DELIMITER);
        for (int index = 0; index < array.length; index++) {
            String value = array[index];
            String fieldName = mapping.get(index);

            setValueIntoFieldOrThrow(value, fieldName, person);
        }

        return person;
    }

    private static void setValueIntoFieldOrThrow(String value, String fieldName, Person person) {
        try {
            Field field = person.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(person, transformValueToFieldType(field, value));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object transformValueToFieldType(Field field, String value) {
        Class<?> type = field.getType();
        Map<Class<?>, Function<String, Object>> typeToFunction = new LinkedHashMap<>();
        typeToFunction.put(String.class, s -> s);
        typeToFunction.put(int.class, s -> Integer.parseInt(value));
        typeToFunction.put(float.class, s -> Float.parseFloat(value));
        typeToFunction.put(LocalDate.class, s -> LocalDate.parse(value));
        return typeToFunction.getOrDefault(type, s -> {
            throw new UnsupportedOperationException("Type is not supported by parser " + type);
        }).apply(value);

        /*if (int.class.equals(type)){
            return Integer.parseInt(value);
        } else if (Float.class.equals(type)){
            return Float.parseFloat(value);
        } else if (String.class.equals(type)){
            return value;
        } else if (LocalDate.class.equals(type)){
            return LocalDate.parse(value);
        } else {
            throw new UnsupportedOperationException("Type is not supported by parser " + type);
        }*/
    }
}
