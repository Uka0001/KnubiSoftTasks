package com.knubisoft.booktasks.shildt.forBegginers7th2019.p14lambda;

class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeTest<Integer> isFactor = (n, d) -> (n%d) == 0;

        if (isFactor.test(10, 2))
            System.out.println("2 є ділителем 10");
        System.out.println();

        SomeTest<Double> isFactorD = (n, d) -> (n%d) == 0;

        if (isFactorD.test(212.0, 4.0))
            System.out.println("4.0 є ділителем 212.0");
        System.out.println();

        SomeTest<String> isIn = (a, b) -> a.indexOf(b) !=-1;

        String str = "Загальний функціональний interface";

        System.out.println("Тестуєма строка: " + str);

        if (isIn.test(str, "face"))
            System.out.println("'face' found");
        else
            System.out.println("'face' not found");
    }
}