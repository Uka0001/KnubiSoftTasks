package com.knubisoft.tasks.codewars;

public class VowelExtractor {
    public static String getVowels(String input) {
        // WRITE YOUR CODE BELOW THIS LINE
        if (input == null) {
            return "";
        } else {
            char [] result = input.toCharArray();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' ||  result[i] == 'o' || result[i] == 'u') {
                    res.append(result[i]);
                }
            }
            return res.toString();
        }

        // WRITE YOUR CODE ABOVE THIS LINE
    }
}
/*Дано рядок input. Треба повернути рядок, що містить виключно голосні літери з рядка input. Поверни порожній рядок, якщо input дорівнює null.

Голосними вважаються наступні символи: a, e, i, o, u.

Приклади:

getVowels("hello world!") => "eoo"
getVowels("aaaa") => "aaaa"
getVowels("v") => ""
getVowels("") => ""*/
