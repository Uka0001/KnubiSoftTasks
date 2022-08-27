package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p30RegularExpretions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp4 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("W+");
        Matcher matcher = pattern.matcher("W WW WWW");

        while (matcher.find()){
            System.out.println("Match: " + matcher.group());
        }
    }
}
