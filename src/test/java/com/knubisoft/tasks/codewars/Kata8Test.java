package com.knubisoft.tasks.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Kata8Test {
    @Test
    public void fixedTests() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Kata8.countBy(1, 10));
        assertArrayEquals(new int[]{2, 4, 6, 8, 10}, Kata8.countBy(2, 5));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 21}, Kata8.countBy(3, 7));
        assertArrayEquals(new int[]{50, 100, 150, 200, 250}, Kata8.countBy(50, 5));
        assertArrayEquals(new int[]{100, 200, 300, 400, 500, 600}, Kata8.countBy(100, 6));
    }
}