package com.knubisoft.tasks.practical.orm.release1v3;

import lombok.SneakyThrows;

import java.util.List;

public interface ORMInterface {

    @SneakyThrows
    <T> List<T> readAll(DataReadWriteSource<?> source, Class<T> cls);

}
