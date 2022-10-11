package com.knubisoft.tasks.algorithm.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorUtilsImpl implements ConstructorUtils {
    @Override
    public <T> T invokeConstructor(Class<T> cls, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (cls == null || args == null) {
            throw new IllegalArgumentException();
        }
        return cls.getDeclaredConstructor(args.getClass()).newInstance(args);
    }

    @Override
    @SneakyThrows
    public <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... parameterTypes) {
        if (cls == null || parameterTypes == null) {
            throw new IllegalArgumentException();
        }

        return cls.getDeclaredConstructor(parameterTypes);
    }
}
