package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        System.out.println("Пoтoк Один запущен: " + ob1.t.isAlive());
        System.out.println("Пoтoк Два запущен: " + ob2.t.isAlive());
        System.out.println("Пoтoк Три запущен: " + ob3.t.isAlive());
        // чекати завершення потоків виконання
        try {
            System.out.println("Oжидaниe завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Головний поток прерван");
            throw new RuntimeException(e);
        }

        System.out.println("Пoтoк Один запущен: " + ob1.t.isAlive());
        System.out.println("Пoтoк Два запущен: " + ob1.t.isAlive());
        System.out.println("Пoтoк Три запущен: " + ob1.t.isAlive());
        System.out.println("Головний поток завершений");
    }
}
