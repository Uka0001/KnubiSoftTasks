package com.knubisoft.tasks.test;

interface Foo{
    int x = 10;
}

public class Test2 {
    public static void main(String[] args) {
        //Foo.x = 20;
        System.out.println(Foo.x);
    }
}
//Compilation Error
