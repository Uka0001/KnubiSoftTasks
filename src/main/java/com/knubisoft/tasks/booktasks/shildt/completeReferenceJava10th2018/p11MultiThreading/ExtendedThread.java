package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class ExtendedThread {
    public static void main(String[] args) {
        new NewThreadThread(); //create new thread

        try {
            for (int i =5;i>0;i--){
                System.out.println("Main thread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread aborted");
            throw new RuntimeException(e);
        }
        System.out.println("Main thread canceled");
    }
}
