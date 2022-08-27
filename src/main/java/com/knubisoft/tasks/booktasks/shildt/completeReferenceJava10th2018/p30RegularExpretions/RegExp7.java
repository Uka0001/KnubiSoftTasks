package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p30RegularExpretions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp7 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher("this is a test.");

        while (matcher.find()){
            System.out.println("Match " + matcher.group());
        }
    }
}
