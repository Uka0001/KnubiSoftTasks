package com.knubisoft.tasks.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTest {
    @Test
    public void testSomething() {
        assertEquals(15, Positive.sum(new int[]{1, 2, 3, 4, 5}));
        assertEquals(13, Positive.sum(new int[]{1, -2, 3, 4, 5}));
        assertEquals(0, Positive.sum(new int[]{}));
        assertEquals(0, Positive.sum(new int[]{-1, -2, -3, -4, -5}));
        assertEquals(9, Positive.sum(new int[]{-1, 2, 3, 4, -5}));
    }
}