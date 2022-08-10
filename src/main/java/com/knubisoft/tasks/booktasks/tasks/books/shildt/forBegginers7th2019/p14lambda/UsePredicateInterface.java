package com.knubisoft.tasks.booktasks.tasks.books.shildt.forBegginers7th2019.p14lambda;

import java.util.function.Predicate;

public class UsePredicateInterface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (n) -> (n%2) == 0;

        if (isEven.test(4)) System.out.println("4 - четное число");

        if (!isEven.test(7)) System.out.println("7 - нечетное число");
    }

}
