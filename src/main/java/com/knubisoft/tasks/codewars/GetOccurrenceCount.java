package com.knubisoft.tasks.codewars;

public class GetOccurrenceCount {
    public static int getOccurrenceCount(String[] colors, String targetColor) {
        // write your code below this line
        int sum = 0;
        for(String each: colors){
            if (each.equals(targetColor)){
                sum+=1;
            }
        }
        return sum;
        // write your code above this line
    }

    public static void main(String[] args) {
        getOccurrenceCount(new String[] {"blue", "blue", "blue"}, "blue"); // 3
        getOccurrenceCount(new String[] {"blue", "green", "red"}, "red"); // 1
        getOccurrenceCount(new String[] {"blue", "green", "red"}, "white"); // 0
        getOccurrenceCount(new String[] {"blue", "green", "red"}, null); // 0
        getOccurrenceCount(new String[0], "blue"); // 0
    }
}
