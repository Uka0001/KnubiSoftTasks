package com.knubisoft.codewars;
/*Introduction
The first century spans from the year 1 up to and
 including the year 100, the second century - from
 the year 101 up to and including the year 200, etc.
Task
Given a year, return the century it is in.*/

public class Solution {
    public static int century(int number) {
        if (number % 100 == 0) {
            return number / 100;
        } else {
            return number / 100 + 1;
        }
    }
}
