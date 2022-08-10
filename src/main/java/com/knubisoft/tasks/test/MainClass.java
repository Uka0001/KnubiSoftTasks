package com.knubisoft.tasks.test;

public class MainClass {

    public static void main(String args[]) {
        String a = "abcd";
        String b = "cbad";

        System.out.println(process(a, b));
    }

    private static boolean process(String a, String b) {
        if (isNotSameLength(a, b))
            return false;

        int index;
        StringBuilder sb = new StringBuilder(b);

        for (char c : a.toCharArray()) {
            index = sb.indexOf(String.valueOf(c));
            if (index != -1)
                sb.deleteCharAt(index);
        }

        return sb.length() == 0;
    }

    private static boolean isNotSameLength(String a, String b) {
        return a.length() != b.length();
    }
}
