package com.knubisoft.tasks.practical.orm.release1v3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RequiredArgsConstructor
@Getter
final class ConnectionReadWriteSource implements DataReadWriteSource<ResultSet> {
    private final Connection source;
    private final String table;

    @Override
    @SneakyThrows
    public ResultSet getContent() {
        Statement statement = source.createStatement();
        return statement.executeQuery("SELECT * FROM " + table);
    }
}