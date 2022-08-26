package com.knubisoft.tasks.pingpong;
//lombock

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PingPong implements Runnable {
    private final String word;
    private final Object monitor;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronizedPrint(i);
        }
    }

    private void synchronizedPrint(int i) {
        synchronized (monitor) {
            System.out.println(word + i);
            try {
                monitor.notifyAll();
                monitor.wait(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}