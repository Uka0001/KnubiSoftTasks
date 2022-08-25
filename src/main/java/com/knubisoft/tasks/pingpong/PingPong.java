package com.knubisoft.tasks.pingpong;

public class PingPong implements Runnable {
    String word;
    Object a;


    public PingPong(String word, Object a) {
        this.word = word;
        this.a = a;
    }


    @Override
    public void run() {
        synchronized (a) {
            for (int i = 0; i < 10; i++) {
                System.out.println(word + i);
                try {
                    a.notifyAll();
                    a.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            /*if (Thread.currentThread().isInterrupted()) {
                // cleanup and stop execution
                // for example a break in a loop
            }*/
        }
    }
}
