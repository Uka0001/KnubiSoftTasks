package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p30RegularExpretions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp3 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("test");
        Matcher matcher = pattern.matcher("test 1 2 3 test");
        while(matcher.find()){
            System.out.println("Pattern \"" + pattern + "\" is detected by index " + matcher.start());
        }
    }
}
