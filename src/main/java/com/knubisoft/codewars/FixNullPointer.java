package com.knubisoft.codewars;

public class FixNullPointer {
    public static void main(String[] args) {
        getUpperCase(null);
    }

    public static String getUpperCase(String inputString) {
        // write your code below this line
        /*try {
            return inputString.toUpperCase();
        } catch (NullPointerException e){
            throw new NullPointerException("The string is null");
        }*/
        if (inputString == null) {
            return "The string is null";
        } else {
            return inputString.toUpperCase();
        }

        // write your code above this line
    }
}
