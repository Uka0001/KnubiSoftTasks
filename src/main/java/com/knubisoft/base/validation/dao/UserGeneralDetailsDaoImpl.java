package com.knubisoft.base.validation.dao;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.ValidationTasksImpl;

import java.util.Optional;

public class UserGeneralDetailsDaoImpl implements UserGeneralDetailsDao {
    private final ValidationTasks instance = new ValidationTasksImpl();

    @Override
    public Optional<ValidationTasks.UserAddressDetails> getById(Long id) {
        return Optional.ofNullable(instance.buildUserAddressDetails());
    }
}
