package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class CallMe {
    /*synchronized*/ void call (String msg){

        try {
            System.out.print("[" + msg);
            Thread.sleep(1000);
            System.out.print("]\n" );
        } catch (InterruptedException e) {
            System.out.println("Aborted");
            throw new RuntimeException(e);
        }

    }
}
