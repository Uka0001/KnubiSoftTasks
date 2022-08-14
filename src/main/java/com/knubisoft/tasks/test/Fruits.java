package com.knubisoft.tasks.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Fruits {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        ListIterator<String> it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            String str = it.previous();
            System.out.println(str);
        }
    }
}

//Banana
//Mango
//Apple
//Mango
