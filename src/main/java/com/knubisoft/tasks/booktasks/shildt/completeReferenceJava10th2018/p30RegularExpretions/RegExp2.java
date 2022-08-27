package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p30RegularExpretions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher("Java 9");
        System.out.println("Search Java in Java 9");
        if (matcher.find()){
            System.out.println("Java in Java 9 is detected");
        } else {
            System.out.println("Java in Java 9 is not detected");
        }
    }
}
