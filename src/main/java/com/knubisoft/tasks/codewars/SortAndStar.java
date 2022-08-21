package com.knubisoft.tasks.codewars;

import org.apache.commons.lang3.CharSet;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAndStar {

    public static String twoSort(String[] s) {
        Arrays.sort(s);
        //String result = s[0].replaceAll(".(?!$)", "$0***");
        return s[0].replaceAll(".(?!$)", "$0***");

        //Clever var from code wars
        // java.util.Arrays.sort(s);
        // return String.join("***",s[0].split(""));

        //My first not right variant with arraylist
        // Arrays.stream(s).sorted().toArray();
//        char[] ch = s[0].toCharArray();
//        List<String> charList = new ArrayList<>();
//        for(char each: ch){
//            charList.add(String.valueOf(each));
//            charList.add("***");
//        }
//        charList.remove(charList.size()-1);
//        String result = charList.toString();
//        return result;
    }
}
/*You will be given a list of strings.
 You must sort it alphabetically (case-sensitive,
  and based on the ASCII values of the chars) and
  then return the first value.

The returned value must be a string,
 and have "***" between each of its letters.

You should not remove or add elements from/to the array.*/
