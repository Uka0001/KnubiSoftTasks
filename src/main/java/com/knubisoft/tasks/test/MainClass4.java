package com.knubisoft.tasks.test;

import java.util.Arrays;

public class MainClass4 {

    public static void main(String[] args) {
        int[] array = {1, 3, 0, 2};
        int[] ints = process(array, e -> e * 2);
        System.out.println(ints[1]);
        byte x = 127;
        byte y = 1;
        byte i = (byte) (x + y);
        System.out.println(i);
    }

    private static int[] process(int[] array, MyFunction function) {
        return Arrays.stream(array)
                .filter(e -> e > 1)
                .map(function::apply)
                .toArray();
    }
}

