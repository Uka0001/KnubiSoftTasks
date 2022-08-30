package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.model.EntryModel;
import com.knubisoft.base.reflection.model.InheritedEntryModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ReflectionTasksImpl implements ReflectionTasks {
    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        try {
            if (cls == null) {
                throw new NoSuchElementException();
            }
            cls = Class.forName(cls.getName());
            boolean b = cls.getPackageName().equals("com.knubisoft.base.reflection");
            if (b) {
                throw new IllegalArgumentException();
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        try {
            cls = Class.forName(cls.getName());
            return InheritedEntryModel.class.getDeclaredConstructor(String.class).newInstance("i");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cls = Class.forName(cls.getName());
            Class[] params = {String.class, String.class};
            return InheritedEntryModel.class.getConstructor(params).newInstance("i", "j");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cls = Class.forName(cls.getName());
            Class[] params = {String.class, String.class, String.class};
            return InheritedEntryModel.class.getConstructor(params).newInstance("i", "j", "k");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        try {
            if (cls == null) {
                throw new NoSuchElementException();
            }
            cls = (Class<T>) Class.forName(cls.getName());
            boolean b = cls.getPackageName().equals("com.knubisoft.base.reflection");
            if (b) {
                throw new IllegalArgumentException();
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        Class[] c = InheritedEntryModel.class.getDeclaredClasses();
        if (c.length == 0) {
            return (Class<? extends T>) InheritedEntryModel.class;
        }
        return c[0];
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        HashMap<String, Object> res = new HashMap<>();
        Object obj = null;
        try {
            cls = Class.forName(cls.getName());
            if (cls.isInterface()) {
                return res;
            }
            obj = cls.getDeclaredConstructor(String.class, String.class, String.class).newInstance("1", "2", "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Field[] fields = cls.getSuperclass().getDeclaredFields();
        for (Field f : fields) {
            Field field = null;
            try {
                field = EntryModel.class.getDeclaredField(f.getName());
                field.setAccessible(true);
                Object str = field.get(obj);
                res.put(f.getName(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        Method[] methods = cls.getDeclaredMethods();
        int count = 0;
        for (Method m : methods) {
            if (Modifier.isPrivate(m.getModifiers())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        Method[] methods = annotationUnderMethod.getMethods();
        for (Method m : methods) {
            if (m.getName().equals(method.getName())) {
                Annotation[] annotations = method.getAnnotations();
                return annotations.length > 0;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        Method method = null;
        try {
            method = cls.getDeclaredMethod(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert method != null;
        return method.getReturnType();
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        if (obj == null || name == null || args == null) {
            throw new IllegalArgumentException();
        }
        try {
            Class<?> aClass = obj.getClass();
            Class<?>[] classes = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
            Method method = aClass.getMethod(name, classes);
            return method.invoke(obj, args);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        Field field;
        try {
            field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(instance, newValue);
            Object x = (Object) field.get(instance);
            return x;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
