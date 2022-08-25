package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class Caller implements Runnable{
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target){
            target.call(msg);
            //synchronized block
        }

    }
}
