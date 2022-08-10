package com.knubisoft.tasks.codewars;
//Given a non-negative integer n, write a function
// to_binary/ToBinary which returns that number in a binary format.

public class Kata3 {

    public static int toBinary(int n) {
        return Integer.parseInt(Integer.toBinaryString(n));
    }

}
