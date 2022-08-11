package com.knubisoft.tasks.codewars;

public class ConvertBooleans {
    public static String[] getStringArray(boolean[] values) {
        // WRITE YOUR CODE BELOW THIS LINE
        String [] arr = new String[values.length];
        for (int i = 0; i < values.length; i++){
            if (values[i] == true){
                arr[i] = "Yes";
            } else if (values[i] == false) {
                arr[i] = "No";
            } else {
                arr[i] = "";
            }
        }
        return arr;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        getStringArray(new boolean[] {true, false}); // ["Yes", "No"]
        getStringArray(new boolean[] {false}); // ["No"]
        getStringArray(new boolean[] {}); // []
    }
}
