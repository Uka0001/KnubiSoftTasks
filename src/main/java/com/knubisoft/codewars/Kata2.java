package com.knubisoft.codewars;
//In this simple assignment you are given a number and have to make
// it negative. But maybe the number is already negative?
public class Kata2 {

    public static int makeNegative(final int x) {
        if (x > 0) {
            return -x;
        } else {
            return x;
        }

    }

}