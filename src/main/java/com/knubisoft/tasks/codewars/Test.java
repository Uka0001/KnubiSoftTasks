package com.knubisoft.tasks.codewars;

public class Test {
    public static void main(String[] args) {
        sum();
    }

    public static int sum() {
        int arraySize = 7;
        int[] array = {1, 4, 0, 8, 0, 9, 9};
        int result = -1;
        int firstZero = 0;
        int secondZero = 0;
        for (int i = 0; i < arraySize - 1; i++) {
            if (array[i] == 0) {
                firstZero = i;
                for (i++; i < arraySize - 1; i++) {
                    if (array[i] == 0) {
                        secondZero = i;
                        result = secondZero - firstZero + 1;
                    }
                }
            }
        }
        return result;
    }
}

