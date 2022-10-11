package com.knubisoft.base.pattern;

import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        try {
            if (text.equals("") | text.equals(" "))
                throw new IllegalArgumentException();
            else
                return text.matches("^\\w+$");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String result = "";
        Pattern pattern = Pattern.compile("^pq*$");

        if (pattern.matcher(text).find()) {
            result = "Found a match!";
        } else {
            result = "Not matched!";
        }
        return result;
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String result = "";
        Pattern pattern = Pattern.compile("\\Bg\\B");

        if (pattern.matcher(text).find()) {
            result = "Found a match!";
        } else {
            result = "Not matched!";
        }
        return result;
    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        } else
            return text.replaceAll("(?<=^|\\.)0+(?!\\.|$)", "");
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        } else
            return text.replaceAll("[aeiouAEIOU]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        } else if (text.length() % 2 != 0) {
            return false;
        }
        Pattern p = Pattern.compile("^\\d{4}|\\d{6}\\d{8}$");
        return p.matcher(text).find();
    }

    @Override
    public String divideDigit(int digit) {
        return String.valueOf(digit).replaceAll("0{3}$", "#000");
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        if (text == null) {
            throw new RuntimeException();
        }
        return text.replaceAll("[^a-zA-Z]", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) throw new IllegalArgumentException();
        else if (text.matches("\\d{10}")) return true;
        else if (text.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        else if (text.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        else if (text.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) return true;
        else if (text.matches("\\(\\d{3}\\)\\d{3}\\d{4}")) return true;
        else return text.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}");
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (text == null || text.length() == 0 || text.equals(" ") || n <= 0 | n > text.length()) {
            throw new RuntimeException();
        }
        text = text.replaceAll("[^qeyuoia]", "");
        if (text.length() == n) {
            return text;
        }
        return text.substring(text.length() - n);
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        }
        Pattern p = Pattern.compile("\\d");
        Pattern p1 = Pattern.compile("\\d$");
        Pattern p2 = Pattern.compile("[+*]{2}");
        return p.matcher(text).find() && !p2.matcher(text).find() && p1.matcher(text).find();
    }

    @Override
    public String insertDash(String text) {
        if (text == null) {
            throw new RuntimeException();
        }
        String[] arr = text.split(" ");
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            if (String.valueOf(s.charAt(0)).equals(String.valueOf(s.charAt(0)).toUpperCase())) {
                res.append(s.replaceAll(String.valueOf(s.charAt(0)), s.charAt(0) + "-"));
            } else {
                res.append(s);
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
}
