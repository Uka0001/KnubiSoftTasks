package com.knubisoft.testtasks;

public class StaticExample {
    static int i;
    static int a = 6;
    int j;
    int b = 6;

    static {
        System.out.println("static initializer");
    }

    {
        System.out.println("initializer");
    }

    StaticExample() {
        System.out.println("Constructor");
    }

    static void staticMethod() {
        System.out.println("static method");
    }

    public static void main(String[] args) {
        System.out.println(StaticExample.a);
        new StaticExample();
    }

}
