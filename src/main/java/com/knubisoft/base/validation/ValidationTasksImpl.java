package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotation.MaxLength;
import com.knubisoft.base.validation.annotation.NotNull;
import com.knubisoft.base.validation.annotation.PrimaryKey;
import com.knubisoft.base.validation.annotation.ReferClass;
import com.knubisoft.base.validation.dao.UserDaoImpl;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidationTasksImpl implements ValidationTasks {
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public void validate(Object instance) {
        Class<?> aClass = instance.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            List<Annotation> annotationList = Arrays
                    .stream(field.getDeclaredAnnotations())
                    .peek(value -> {
                        Class<?> annotationType = value.annotationType();
                        if (annotationType == NotNull.class) {
                            field.setAccessible(true);
                            try {
                                if (field.get(instance) == null) {
                                    throw new NullPointerException("The field : "
                                            + field.getName() + " is null!");
                                }
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    })
                    .collect(Collectors.toList());
            for (Annotation annotation : annotationList) {
                if (annotation.annotationType() == MaxLength.class) {
                    MaxLength maxLengthAnnotation = (MaxLength) annotation;
                    int maxLength = maxLengthAnnotation.maxLength();
                    field.setAccessible(true);
                    String fieldValue = null;
                    try {
                        fieldValue = (String) field.get(instance);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (fieldValue.length() > maxLength) {
                        throw new IllegalArgumentException("The max length of " + field.getName()
                                + " must be less or equal:" + maxLength + "!");
                    }
                }
                if (annotation.annotationType() == PrimaryKey.class) {
                    PrimaryKey primaryKeyAnnotation = (PrimaryKey) annotation;
                    Long id;
                    try {
                        field.setAccessible(true);
                        id = (Long) field.get(instance);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (userDaoImpl.getAllId().contains(id) && primaryKeyAnnotation.isPrimary()) {
                        throw new IllegalArgumentException("This id: " + id
                                + " is not uniq number!");
                    }
                }
                if (annotation.annotationType() == ReferClass.class) {
                    ReferClass referClassAnnotation = (ReferClass) annotation;
                    Class<?> referClass = referClassAnnotation.referClass();
                    Optional optional;
                    Long id;
                    try {
                        Class<?> daoClass = Class.forName(UserDaoImpl.class.getPackageName() + "."
                                + referClass.getSimpleName() + "Dao");
                        field.setAccessible(true);
                        id = (Long) field.get(instance);
                        Set<Class<?>> subTypesOf = new Reflections(daoClass.getPackageName())
                                .getSubTypesOf((Class<Object>) daoClass);
                        Class<?> daoImpl = new ArrayList<>(subTypesOf).get(0);
                        Method methodGetById = daoImpl.getMethod("getById", Long.class);
                        optional = (Optional) methodGetById.invoke(daoImpl.getConstructor().newInstance(), id);
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (optional.isEmpty()) {
                        throw new IllegalArgumentException("The "
                                + StringUtil.splitStringByUpperCase(referClass.getName())
                                + "is absent by id:" + id + "!");
                    }
                }
            }
        }
    }

    @Override
    public User buildUser() {
        return Stream.of(new User())
                .peek(user -> user.setId(4L))
                .peek(user -> user.setName("Bob"))
                .peek(user -> user.setSurname("Smith"))
                .peek(user -> user.setMarried(true))
                .peek(user -> user.setCountOfChildren(2))
                .peek(user -> user.setCountOfPets(1))
                .peek(user -> user.setFkUserGeneralDetails(4L))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public UserGeneralDetails buildUserGeneralDetails() {
        return Stream.of(new UserGeneralDetails())
                .peek(ugd -> ugd.setId(4L))
                .peek(ugd -> ugd.setCountry("Ukraine"))
                .peek(ugd -> ugd.setOblast("Kharkiv"))
                .peek(ugd -> ugd.setCity("Kharkiv"))
                .peek(ugd -> ugd.setFkUserAddressDetails(4L))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public UserAddressDetails buildUserAddressDetails() {
        return Stream.of(new UserAddressDetails())
                .peek(userAddressDetails -> userAddressDetails.setId(4L))
                .peek(userAddressDetails -> userAddressDetails.setZipCode("61120"))
                .peek(userAddressDetails -> userAddressDetails.setStreet("Vasil Stus"))
                .peek(userAddressDetails -> userAddressDetails.setNumberOfHouse("5A"))
                .findFirst()
                .orElseThrow();
    }
}
