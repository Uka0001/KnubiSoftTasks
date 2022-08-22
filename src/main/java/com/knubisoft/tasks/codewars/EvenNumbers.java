package com.knubisoft.tasks.codewars;

import java.util.Arrays;

public class EvenNumbers {
    int[] result;

    public static int[] divisibleBy(int[] numbers, int divider) {
//        return Arrays.stream(numbers)
//                .filter(i -> (i % divider) == 0).toArray();
//    }
         int count = 0;
        for (int number : numbers){
          if (number % divider == 0){
            count ++;
          }
        }
        int[] arr = new int[count];
        int i = 0;
        for (int number : numbers){
          if (number % divider == 0){
            arr[i] = number;
            i++;
          }
        }
        return arr;
    }
}
/*Complete the function which takes
 two arguments and returns all numbers
  which are divisible by the given divisor.
   First argument is an array of numbers
    and the second is the divisor.

Example(Input1, Input2 --> Output)

[1, 2, 3, 4, 5, 6], 2 --> [2, 4, 6]*/
