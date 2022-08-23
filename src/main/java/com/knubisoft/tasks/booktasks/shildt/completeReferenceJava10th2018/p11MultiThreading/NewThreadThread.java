package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class NewThreadThread extends Thread{
    NewThreadThread(){
        //create new Thread
        super("Demonstration Thread");
        System.out.println("Demonstration Thread" + this);
        start();
    }
    public void run(){
        try {
            for(int i = 5; i>0; i--){
                System.out.println("Дочірній thread" + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочірній thread aborted");
            throw new RuntimeException(e);
        }
        System.out.println("Дочірній thread canceled");
    }
}
