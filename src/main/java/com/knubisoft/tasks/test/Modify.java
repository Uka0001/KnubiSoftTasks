package com.knubisoft.tasks.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Modify {
    public void modify() {
        Consumer<List<Integer>> modFirst = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
        Consumer<List<Integer>> modSecond = list -> {
            list.stream().map(a -> Math.pow(a, 2));
        };

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-1);
        list.add(2);

        modFirst.accept(list);
        modSecond.accept(list);
        list.forEach(a -> System.out.print(a + " "));
    }
}
// ----- [ 6 -2 4 ]------
