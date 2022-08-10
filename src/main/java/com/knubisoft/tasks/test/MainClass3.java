package com.knubisoft.tasks.test;

public class MainClass3 {

    public static void main(String[] args) {
        TestClass1 test = new TestClass1();
        int sequence = test.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 1, 4});
        System.out.println(sequence);
    }
}

class TestClass1 {

    public int sequence(int[] arr) {
        int bestSum = 0;
        int currentSum = 0;
        for (int num : arr) {
            currentSum = Math.max(0, currentSum + num);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
