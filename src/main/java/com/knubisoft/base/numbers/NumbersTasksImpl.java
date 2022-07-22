package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        int x = firstNumber;
        int y = secondNumber;
        x = x + y;
        y = x - y;
        x = x - y;
    }

    @Override
    public boolean isUglyInt(int number) {
        boolean x = true;
        if (number == 0) {
            x = false;
        } else {
            while (number != 1) {
                if (number % 5 == 0) {
                    number /= 5;
                } else if (number % 3 == 0) {
                    number /= 3;
                }
                // To check if number is divisible by 2 or not
                else if (number % 2 == 0) {
                    number /= 2;
                } else {
                    x = false;
                    break;
                }
            }
        }
        return x;
    }

    @Override
    public int addDigits(int number) {
        return -1;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        return false;
    }

    @Override
    public boolean isPrime(int number) {
        return false;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        return false;
    }

    @Override
    public BigInteger factorial(int number) {
        return BigInteger.ZERO;
    }

    @Override
    public boolean palindrome(int number) {
        return false;
    }

    @Override
    public boolean isAutomorphic(int number) {
        return false;
    }
}
