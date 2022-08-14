package com.knubisoft.tasks.test;


import java.util.HashMap;
import java.util.Map;

public class MainClass6 {

    public static void main(String[] args) {
        int result = new TestClass2()
                .count("IndivisibilitY");
        System.out.println(result);
    }
}

class TestClass2 {

    public int count(String text) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char symbol : text.toLowerCase().toCharArray()) {
            if (map.compute(symbol, (key, value) -> (value == null) ? 1 : ++value) == 2) {
                count++;
            }
        }
        return count;
    }
}
// ----1------
