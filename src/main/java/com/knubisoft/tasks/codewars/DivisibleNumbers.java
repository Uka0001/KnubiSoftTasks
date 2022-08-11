package com.knubisoft.tasks.codewars;

public class DivisibleNumbers {
    public static int[] getDivisibleNumbers(int[] numbers, int divider) {
        //write your code below this line
        int size = 0;
        for(int number: numbers){
            if (number > 0 && number % divider == 0){
                size+=1;
            }
        }
        int [] result = new int[size];
        int counter = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] != 0 && numbers[i] > 0 && numbers[i] % divider == 0){
                result[counter++] = numbers [i];
                //counter++;
            }
        }
        return result;
        //write your code above this line
    }

    public static void main(String[] args) {
        //int [] numbers = {2, 5, 8, 0, 7, 1, -4};
        //int divider = 2;
        int [] numbers = {0, 11, 9, -3, 7, 22, -1, -22, 113, 741, 32};
        int divider = 11;
        getDivisibleNumbers(numbers, divider);

//        int[] result = {2, 8};
// тільки числа 2 і 8 додатні та діляться націло на 2
    }
}
