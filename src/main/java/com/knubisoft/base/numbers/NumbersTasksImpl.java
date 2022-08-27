package com.knubisoft.base.numbers;

import java.math.BigInteger;
import java.util.Collections;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        int x = firstNumber;
        int y = secondNumber;
        x = secondNumber;
        y = firstNumber;
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
        int sum = 0;
        while (number > 0 || sum > 9) {
            if (number == 0) {
                number = sum;
                sum = 0;
            }
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        int sum = 0;
        if (number == 0) {
            return false;
        } else {
            for (int temp = number; temp > 0; temp /= 10)
                sum += temp % 10;
            return (number % sum == 0);
        }
    }

    @Override
    public boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        String [] array = Integer.toString(number).split("");
        int result = 0;
        for (String each: array)
            result += Math.pow(Integer.parseInt(each), array.length);
        return number == result;
    }

    @Override
    public BigInteger factorial(int number) {
        BigInteger bigInteger = BigInteger.valueOf(1);
        for (int i = 2; i <= number; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }

    @Override
    public boolean palindrome(int number) {
        String original = Integer.toString(number);;
        String reverse = "";
        for (int i = original.length()-1; i >= 0; i--){
            reverse += original.charAt(i);
        }
        return original.equals(reverse);
    }

    @Override
    public boolean isAutomorphic(int number) {
        long pow = (long) Math.pow(number, 2);
        long tmp = number;
        StringBuilder stringBuilder = new StringBuilder();
        while (number != 0) {
            stringBuilder.append(pow % 10);
            number /= 10;
            pow /= 10;
        }
        int num = Integer.parseInt(stringBuilder.reverse().toString());
        return tmp == num;
    }
}
