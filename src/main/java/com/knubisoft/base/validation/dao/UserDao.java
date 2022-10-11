package com.knubisoft.base.validation.dao;

import com.knubisoft.base.validation.ValidationTasks;

import java.util.List;

public interface UserDao {
    List<Long> getAllId();

    ValidationTasks.User findById(Long id);
}
