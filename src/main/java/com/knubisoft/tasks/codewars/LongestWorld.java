package com.knubisoft.tasks.codewars;

public class LongestWorld {
    public static int findLongest(String sentence) {
        // WRITE YOUR CODE BELOW THIS LINE
        int count = 0;
        if (sentence == null || sentence.equals("")) {
            count = 0;
        } else {
            String[] word = sentence.split(" ");
            //String maxLenthWord = "";

            for (int i = 0; i < word.length; i++) {

                if (word[i].length() >= count) {
                    //maxLenthWord = word[i];
                    count = word[i].length();
                }
            }
        }
        return count;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        findLongest(""); //== 0
        findLongest(null); //== 0
        findLongest("cate"); //== 4
        findLongest("Academy"); //== 7
    }
}
