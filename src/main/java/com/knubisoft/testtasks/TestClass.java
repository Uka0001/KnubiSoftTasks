package com.knubisoft.testtasks;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
//Пример входящих данных строка "1|15|59, 1|47|6, 1|17|20, 1|32|34"

class TestClass {

    public String statistic(String strg) {
        int[] arr = Arrays.stream(strg.split(", "))
                .mapToInt(time -> LocalTime.parse(time, DateTimeFormatter.ofPattern("H|mm|s")).toSecondOfDay())
                .toArray();
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        Arrays.sort(arr);

        LocalTime range = LocalTime.ofSecondOfDay(stat.getMax() - stat.getMin());
        LocalTime average = LocalTime.ofSecondOfDay((long) stat.getAverage());
        LocalTime median = arr.length % 2 == 0
                ? LocalTime.ofSecondOfDay((arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2)
                : LocalTime.ofSecondOfDay(arr[arr.length / 2]);

        return String.format("R: %1$tH|%1$tM|%1$tS A: %2$tH|%2$tM|%2$tS M: %3$tH|%3$tM|%3$tS",
                range, average, median);
    }
}