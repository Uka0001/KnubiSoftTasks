package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p30RegularExpretions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;
        boolean found;
        pattern = Pattern.compile("Java");
        matcher = pattern.matcher("Java");
        found = matcher.matches();

        System.out.println("Java equals Java? ");

        if (found){
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }

        System.out.println();

        System.out.println("Java equals Java9 ?");

        Matcher matcher1 = pattern.matcher("Java9");
        found = matcher1.matches();

        if (found){
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }
    }
}
