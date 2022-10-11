package com.knubisoft.base.validation.dao;

import com.knubisoft.base.validation.ValidationTasks;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private static List<Long> uniqIdStorage = List.of(1L, 2L, 3L);

    public List<Long> getAllId() {
        return uniqIdStorage;
    }

    public ValidationTasks.User findById(Long id) {
        return null;
    }
}
