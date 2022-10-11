package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.HashMap;
import java.util.Map;

public class CharsInStringImpl implements CharsInString {
    @Override
    public Map<Character, Integer> charactersCount(String text) {
        Map<Character, Integer> map = new HashMap<>();
        text = text.replaceAll(" ", "");
        for (Character c : text.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
