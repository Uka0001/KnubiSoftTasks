package com.knubisoft.base.validation.dao;

import com.knubisoft.base.validation.ValidationTasks;

import java.util.Optional;

public interface UserAddressDetailsDao {
    Optional<ValidationTasks.UserAddressDetails> getById(Long id);
}
