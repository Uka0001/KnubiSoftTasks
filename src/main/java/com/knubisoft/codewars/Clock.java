package com.knubisoft.codewars;

/*Clock shows h hours, m minutes and s seconds after midnight.

Your task is to write a function which returns the time since midnight in milliseconds.*/
public class Clock {
    public static int Past(int h, int m, int s) {
        //Happy Coding! ^_^
        int milliseconds;
        milliseconds = s * 1000 + m * 60000 + h * 3600000;
        return milliseconds;
    }
}
