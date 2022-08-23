package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class NewThread implements Runnable {
    Thread t;

    NewThread() {
        // create new, second thread
        t = new Thread(this, "Demonstration thread");
        System.out.println("Дочерній поток створений " + t);
        t.start(); // start thread
    }

    //точка входу у другий потік виконання
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Дочерній поток" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Дочерній поток canceled");

    }
}
