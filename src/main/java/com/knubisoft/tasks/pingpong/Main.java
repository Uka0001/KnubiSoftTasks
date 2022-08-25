package com.knubisoft.tasks.pingpong;

public class Main {
    public static void main(String[] args) {
        Object a = new Object();
        Runnable p1 = new PingPong("Ping ", a);
        Thread t1 = new Thread(p1);
        t1.setName("Ping thread");
        t1.start();

        Runnable p2 = new PingPong("Pong ", a);
        Thread t2 = new Thread(p2);
        t2.setName("Pong thread");
        t2.start();
    }
}
