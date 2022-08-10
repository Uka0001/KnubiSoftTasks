package com.knubisoft.tasks.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UtilClass {
    public static final int HEADER_ROW = 0;
    //...

    public static List<Map<String, String>> getVariationsMapList(
            final List<String[]> variations) {
        List<Map<String, String>> mapList =
                new ArrayList<>(variations.size());
        for (int rowNumber = 1; rowNumber < variations.size(); rowNumber++) {
            enrichMapList(mapList, variations.get(HEADER_ROW),
                    variations.get(rowNumber));
        }
        return mapList;
    }

    private static void enrichMapList(final List<Map<String, String>> mapList,
                                      final String[] headerRow,
                                      final String[] dataRow) {
        Map<String, String> rowMap = new HashMap<>(headerRow.length);
        for (int columnNumber = 0; columnNumber < headerRow.length; columnNumber++) {
            rowMap.put(headerRow[columnNumber], dataRow[columnNumber]);
        }
        mapList.add(rowMap);
    }
}
