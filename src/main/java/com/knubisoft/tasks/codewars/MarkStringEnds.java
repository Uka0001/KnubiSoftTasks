package com.knubisoft.tasks.codewars;

public class MarkStringEnds {
    public static String[] markStringEnds(String originalString) {
        // write your code below this line
        char[] charArr = originalString.toCharArray();
        StringBuilder builderFirst = new StringBuilder();
        StringBuilder builderLast = new StringBuilder();
        String[] newString = new String[2];
        if (originalString.equals(originalString.toUpperCase())) {
            newString[0] = originalString;
            newString[1] = originalString;
        } else if (charArr.length > 0) {
            builderFirst.append(String.valueOf(charArr[0]).toUpperCase());
            for (int i = 1; i < charArr.length; i++) {
                builderFirst.append(charArr[i]);
            }
            for (int j = 0; j < charArr.length; j++) {
                builderLast.append(charArr[j]);
            }
            builderLast.deleteCharAt(charArr.length - 1);
            builderLast.append(String.valueOf(charArr[charArr.length - 1]).toUpperCase());
            newString[0] = builderFirst.toString();
            newString[1] = builderLast.toString();
        }

        return newString;
        // write your code above this line
    }

    public static void main(String[] args) {
        markStringEnds("hello"); // ["Hello", "hellO"]
        markStringEnds("example"); // ["Example", "examplE"]
        markStringEnds("Bob"); // ["Bob", "BoB"]
        markStringEnds("ALICE"); // ["ALICE", "ALICE"]
        markStringEnds("wow!"); // ["Wow!", "wow!"]
        markStringEnds("o"); // ["O", "O"]
    }
}
