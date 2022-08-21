package com.knubisoft.tasks.codewars;

public class Positive{

    public static int sum(int[] arr){
        int sum = 0;
        for (int each: arr){
            if (each > 0){
                sum += each;
            }
        }
        return sum;
    }

    //best practice and clever from code wars
    // public static int sum(int[] arr){
    //        return Arrays.stream(arr).filter(v -> v > 0).sum();
    //    }
}
//You get an array of numbers,
// return the sum of all of the positives ones.
//
//Example [1,-4,7,12] => 1 + 7 + 12 = 20
//
//Note: if there is nothing to sum,
// the sum is default to 0.
