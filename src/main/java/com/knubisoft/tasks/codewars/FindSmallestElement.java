package com.knubisoft.tasks.codewars;

public class FindSmallestElement {
    public static int findSmallestElement(int[] nums) {
        // WRITE YOUR CODE BELOW THIS LINE
        int min = nums[0];
        for(int each: nums){
            if(min >= each){
                min = each;
            }
        }
        return min;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        findSmallestElement(new int [] {0}); //=> 0
        findSmallestElement(new int [] {1, 1, 1}); //=> 1
        findSmallestElement(new int [] {-1, -4, -3, -2}); //=> -4
    }
}
