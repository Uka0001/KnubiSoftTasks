package com.knubisoft.tasks.codewars;

//import java.util.Arrays;
//import java.util.stream.IntStream;

public class CombineArrays {
    public static int[] getCombinedArray(int[] firstArray, int[] secondArray) {
        // first variant:
        //return IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray();
        //second variant:
        int firstLength = firstArray.length;
        int secondLength = secondArray.length;
        int [] array = new int [firstLength+secondLength];
        int i = 0;
        for(int each: firstArray){
            array[i] = each;
            i++;
        }
        for(int each: secondArray){
            array[i] = each;
            i++;
        }
        return array;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        getCombinedArray(new int[]{1, 2}, new int[]{3, 4}); // [1, 2, 3, 4]
        getCombinedArray(new int[]{56}, new int[]{-32}); // [56, -32]
        getCombinedArray(new int[]{}, new int[]{}); // []
        getCombinedArray(new int[]{}, new int[]{20, 10}); // [20, 10]
    }
}
