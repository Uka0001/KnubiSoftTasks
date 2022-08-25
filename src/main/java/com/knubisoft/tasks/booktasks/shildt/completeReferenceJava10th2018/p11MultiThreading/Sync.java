package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class Sync {
    public static void main(String[] args) {
        CallMe target = new CallMe();
//        Caller ob1 = new Caller(target, "Welcome");
//        Caller ob2 = new Caller(target, "to synchronized");
//        Caller ob3 = new Caller(target, "world");

        // чекати завершення потоку виконання

        try {
            Caller ob1 = new Caller(target, "Welcome");
            ob1.t.join();
            Caller ob2 = new Caller(target, "to synchronized");
            ob2.t.join();
            Caller ob3 = new Caller(target, "world");
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Aborted");
            throw new RuntimeException(e);
        }
    }
}
