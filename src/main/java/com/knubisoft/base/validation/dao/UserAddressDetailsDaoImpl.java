package com.knubisoft.base.validation.dao;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.ValidationTasksImpl;

import java.util.Optional;

public class UserAddressDetailsDaoImpl implements UserAddressDetailsDao {
    private final ValidationTasks instance = new ValidationTasksImpl();

    public Optional<ValidationTasks.UserAddressDetails> getById(Long id) {
        return Optional.ofNullable(instance.buildUserAddressDetails());
    }
}
