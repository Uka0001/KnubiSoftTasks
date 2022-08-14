package com.knubisoft.tasks.test;

class A {
    A() {
        System.out.println("Koнcтpyктop А");
    }
}
class B extends A {
    B() {
        System.out.println("Koнcтpyктop B");
    }
}
class C extends B {
    C() {
        System.out.println("Koнcтpyктop C");
    }
}

class Test1 {
    public static void main(String args[]) {
        C c = new C();
    }
}

//Koнcтpyктop А
//Koнcтpyктop B
//Koнcтpyктop C
