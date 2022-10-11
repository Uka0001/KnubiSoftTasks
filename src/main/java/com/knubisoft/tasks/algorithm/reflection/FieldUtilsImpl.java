package com.knubisoft.tasks.algorithm.reflection;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FieldUtilsImpl implements FieldUtils {
    @SneakyThrows
    @Override
    public Field getField(Class<?> cls, String fieldName) {
        Class<?> clazz = Class.forName(cls.getName());
        return clazz.getDeclaredField(fieldName);
    }

    @SneakyThrows
    @Override
    public Field getField(Class<?> cls, String fieldName, boolean forceAccess) {
        Class<?> clazz = Class.forName(cls.getName());
        return clazz.getDeclaredField(fieldName);
    }

    @SneakyThrows
    @Override
    public Field getDeclaredField(Class<?> cls, String fieldName) {
        Class clazz = Class.forName(cls.getName());
        return clazz.getDeclaredField(fieldName);
    }

    @SneakyThrows
    @Override
    public Field[] getAllFields(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        Class clazz = Class.forName(cls.getName());
        if (clazz.isInterface()) {
            return cls.getFields();
        }
        return clazz.getSuperclass().getDeclaredFields();
    }

    @SneakyThrows
    @Override
    public Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
        Class<?> clazz = Class.forName(cls.getName());
        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldsWithAnnotation = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(annotationCls)) {
                fieldsWithAnnotation.add(f);
            }
        }
        Field[] res = new Field[fieldsWithAnnotation.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = fieldsWithAnnotation.get(i);
        }
        return res;
    }
}
