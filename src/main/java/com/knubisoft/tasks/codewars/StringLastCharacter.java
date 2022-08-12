package com.knubisoft.tasks.codewars;

public class StringLastCharacter {
    public static char getLastCharacter(String input) {
        // WRITE YOUR CODE BELOW THIS LINE
        char [] arr = input.toCharArray();
        return arr[arr.length-1];
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        getLastCharacter("a"); //=> 'a'
        getLastCharacter("abcde"); // => 'e'
        getLastCharacter("12345"); // => '5'
    }
}
