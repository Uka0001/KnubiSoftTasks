package com.knubisoft.codewars;

public class MakeAbbr {
    public static void main(String[] args) {
        makeAbbr("national aeronautics space administration");

    }

    public static String makeAbbr(String fullName) {
        String[] fullNameArr = fullName.split(" ");
        char[] charAtIndexOneArr = new char[fullNameArr.length];
        int i = 0;
        for (String each : fullNameArr) {

            charAtIndexOneArr[i] = each.charAt(0);
            i++;
        }
        String result = String.valueOf(charAtIndexOneArr).toUpperCase();
        return result;
    }
}
