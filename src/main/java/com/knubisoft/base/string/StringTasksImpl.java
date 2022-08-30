package com.knubisoft.base.string;

import java.util.*;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if (original == null) {
            throw new IllegalArgumentException();
        }
        return new StringBuilder(original).reverse().toString();
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || toInsert == null || original.length() == 0 || toInsert.length() == 0) {
            throw new IllegalArgumentException();
        }
        toInsert = toInsert.replaceAll("\\r\\n", "\n");
        char[] originalArr = original.toCharArray();
        char[] toInsertArr = toInsert.toCharArray();
        char[] res = new char[originalArr.length + toInsertArr.length];
        System.arraycopy(originalArr, 0, res, 0, originalArr.length);
        if (toInsertArr.length + originalArr.length / 2 - originalArr.length / 2 >= 0)
            System.arraycopy(toInsertArr, 0, res, originalArr.length / 2, toInsertArr.length + originalArr.length / 2 - originalArr.length / 2);
        for (int i = originalArr.length / 2 + toInsertArr.length, j = originalArr.length / 2; i < original.length() + toInsert.length(); i++, j++) {
            res[i] = originalArr[j];
        }
        original = new String(res);
        return original;
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || position > original.length() || original.length() == 0 || position < 0) {
            throw new IllegalArgumentException();
        }
        String begin = original.substring(0, position);
        String end = original.substring(position);
        return begin + toInsert + end;
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || toAppend == null || original.length() == 0) {
            throw new NoSuchElementException();
        }
        char[] res = toAppend.toCharArray();
        for (char re : res) {
            original.append(re);
        }
        return new String(original);
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        if (palindrome == null) {
            throw new RuntimeException();
        }
        char[] array = palindrome.toCharArray();
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            if (array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String[] arr = str.split("");
        for (String s : arr) {
            if (s.equals(s.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String uniqueChar = "";
        char[] s = str.toLowerCase().toCharArray();
        HashMap<Character, Integer> arr = new HashMap<>();
        for (char c : s) {
            if (arr.containsKey(c)) {
                arr.put(c, 2);
            } else {
                arr.put(c, 1);
            }
        }

        for (char c : s) {
            for (Map.Entry<Character, Integer> set : arr.entrySet()) {
                Character key = set.getKey();
                Integer value = set.getValue();
                if (c == key && value == 1) {
                    uniqueChar += c;
                }
            }
        }
        return uniqueChar;
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        char[] s = str.toCharArray();
        String res = "";
        for (char c : s) {
            if (c != charToRemove) {
                res += c;
            }
        }
        return res;
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        String[] arr;
        if (str.contains("-")) {
            arr = str.split("-");
        } else if (str.contains("_")) {
            arr = str.split("_");
        } else {
            arr = str.split(" ");
        }

        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == arr[i].toLowerCase().charAt(0)) {
                if (i == 0) {
                    res += arr[i];
                } else {
                    res += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
                }
            } else {
                if (arr[i].charAt(0) == arr[i].toUpperCase().charAt(0) && i == 0) {
                    res += arr[i].toLowerCase();
                } else {
                    res += arr[i];
                }
            }
        }
        System.out.println(res);
        return res;
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder builder = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int find = 0;
            for (int j = i; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    find++;
                    if (find > 9) {
                        find = 1;
                    }
                    builder.append(find);
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String res = "";
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character c : arr) {
            list.add(c);

        }
        Collections.sort(list);
        for (Character c : list) {
            res += c;
        }
        System.out.println(res);
        return res;
    }
}
