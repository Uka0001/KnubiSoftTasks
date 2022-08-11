package com.knubisoft.tasks.codewars;

public class GetHighestAndLowestAge {
    public static int[] getHighestAndLowestAge(int[] ages) {
        // write your code below this line
        int [] result = new int[2];
        if (ages.length == 1){
            result[0] = ages [0];
            result[1] = ages [0];
        } else {
            int min = ages [0];
            int max = 0;
            for (int each: ages){
            if (each > max){
                max = each;
            }
            if (each <= min ){
                min = each;
            }
            result [0] = max;
            result [1] = min;
            }
        }
        return result;
        // write your code above this line
    }

    public static void main(String[] args) {
        getHighestAndLowestAge(new int[] {10, 40, 36}); // [40, 10]
        getHighestAndLowestAge(new int[] {60, 4, 14, 20, 97}); // [97, 4]
        getHighestAndLowestAge(new int[] {35}); // [35, 35]
// бо 35 - це одночасно найбільший та найменший вік
    }
}
