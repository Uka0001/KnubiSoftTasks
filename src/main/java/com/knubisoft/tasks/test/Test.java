package com.knubisoft.tasks.test;

public class Test {
    public static void main(String args[]) {
        int x = 9;
        if (x == 9) {
            /*int*/ x = 8;
            System.out.println(x);
        }
    }
}
// - Compilation Error!