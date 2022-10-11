package com.knubisoft.tasks.algorithm.fibonacci;

public class FibonacciImpl implements Fibonacci {
    @Override
    public int generateNFibonacciSequence(int n) {
        long first = 0;
        long second = 1;
        long result = n;
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return (int) result;
    }
}
