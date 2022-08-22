package com.knubisoft.tasks.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution1Test {

    @Test
    public void testSomething() {
        assertEquals(Solution1.check(new Object[]{66, 101}, 66), true);
        assertEquals(Solution1.check(new Object[]{80, 117, 115, 104, 45, 85, 112, 115}, 45), true);
        assertEquals(Solution1.check(new Object[]{'t', 'e', 's', 't'}, 'e'), true);
        assertEquals(Solution1.check(new Object[]{"what", "a", "great", "kata"}, "kat"), false);
    }

}