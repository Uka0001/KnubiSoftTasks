package com.knubisoft.tasks.codewars;

public class CountTheMonkeys {
    public static int[] countTheMonkeys(int count) {
        // write your code below this line
        int [] arr = new int[count];
        for(int i = 0; i < count; i++){
            arr[i] += i+1;
        }
        return arr;
        // write your code above this line
    }

    public static void main(String[] args) {
        countTheMonkeys(5); // [1, 2, 3, 4, 5]
        countTheMonkeys(8); // [1, 2, 3, 4, 5, 6, 7, 8]
        countTheMonkeys(0); // [] (порожній масив)
    }
}
