package com.knubisoft.tasks.codewars;

public class CountOddPositions {
    public static int countOddPositionChars(String[] array) {
        // WRITE YOUR CODE BELOW THIS LINE
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (i % 2 == 0){
                count += array[i].length();
            }
        }
        return count;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        countOddPositionChars(new String[]{"Hello", "world", "from", "array"}); // => 9
       // Загальна кількість символів "Hello" та "from": 5 + 4 = 9
    }
}
