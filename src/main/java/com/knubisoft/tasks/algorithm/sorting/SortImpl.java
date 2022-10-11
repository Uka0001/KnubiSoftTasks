package com.knubisoft.tasks.algorithm.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortImpl implements Sort {

    @Override
    public Map<Integer, List<Integer>> sortKeysAndValues(Map<Integer, List<Integer>> input) {
        Map<Integer, List<Integer>> sortedMap = new HashMap<>();

        int i = 0;
        for (Map.Entry<Integer, List<Integer>> each : input.entrySet()) {
            i++;
            sortedMap.put(each.getKey(), input.get(i).stream().sorted().collect(Collectors.toList()));
        }

        return sortedMap;
    }
}
