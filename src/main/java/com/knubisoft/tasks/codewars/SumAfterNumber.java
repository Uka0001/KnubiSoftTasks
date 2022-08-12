package com.knubisoft.tasks.codewars;
/*Дано масив чисел values і значення startValue.
У цьому завданні знайди та поверни суму всіх чисел,
які знаходяться в масиві після значення startValue.
Зверни увагу:
результуюча сума не повинна містити значення startValue;
якщо масив не містить startValue - поверни 0;
якщо масив містить лише одне значення, яке дорівнює
 startValue - поверни 0.*/

public class SumAfterNumber {
    public static int getSum(int[] values, int startValue) {
        // WRITE YOUR CODE BELOW THIS LINE
        boolean startValueFound = false;
        int sum = 0;
        for (int element : values) {
            if (startValueFound) {
                sum += element;
            }
            if (element == startValue) {
                startValueFound = true;
            }
        }
        return sum;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        getSum(new int[]{1, 2, 3}, 1); // 2 + 3 = 5
        getSum(new int[]{10, 2, 50, 3, 4, 0}, 50); // 3 + 4 + 0 = 7
        getSum(new int[]{10, 2, 50, 3, 4, 0}, -100); // 0 (бо в масиві немає значення -100)
        getSum(new int[]{10}, 10); // 0
        getSum(new int[]{9, -12, 0, 4, -59, -1}, 12);
        getSum(new int[]{3, 3, 3}, 3);

    }
}
