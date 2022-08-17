package com.knubisoft.tasks.practical.orm.release1v3;

import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
public class Table {

    private final Map<Integer, Map<String, String>> table;

    int size() {
        return table.size();
    }

    Map<String, String> getTableRowByIndex(int row) {
        Map<String, String> result = table.get(row);
        return result == null ? null : new LinkedHashMap<>(result);
    }
}