package com.knubisoft.testtasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*protected*/ class Example {
    public static void main(String args[]) {
        /*String test = "abc";
        test = test + test;
        System.out.println(test);*/

      // output 2
        /*  int[][] x = {{3,1,4},{1,5,9}};

        int[] y = {2,6,7};

        y = x[1];

        y[1] = 1;

        System.out.println(x[0][1] + x[1][1]);*/

        //output -1
        /*Integer x = 5;
        Integer y = 10;
        System.out.println(x.compareTo(y));*/
    }

    public void modify(){
        Consumer<List<Integer>> modFirst = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
        Consumer<List<Integer>> modSecond = list -> {
            list.stream().map(a -> Math.pow(a, 2));
        };

        List <Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-1);
        list.add(2);

        modFirst.accept(list);
        modSecond.accept(list);
        list.forEach(a -> System.out.println(a + " "));
    }
}