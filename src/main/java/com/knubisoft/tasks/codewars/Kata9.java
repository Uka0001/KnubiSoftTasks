package com.knubisoft.tasks.codewars;

public class Kata9 {
    public static int[] invert(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
                result[i] = array[i] * -1;
        }
        return result;

        //best practise from code wars -1
        //return java.util.Arrays.stream(array).map(i -> -i).toArray();
        //
        // best practise from code wars -2
        // array[i] *= -1;
        //  }
        //
        //  return array;
    }
}
//Given a set of numbers, return
// the additive inverse of each.
// Each positive becomes negatives,
// and the negatives become positives.
