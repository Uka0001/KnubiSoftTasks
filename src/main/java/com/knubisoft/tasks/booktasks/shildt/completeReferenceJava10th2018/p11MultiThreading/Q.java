package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

public class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException catch");
            }
        System.out.println("Received " + n);
        valueSet = false;
        notify();
        return n;
    }


    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException catch");
                throw new RuntimeException(e);
            }
            this.n = n;
            valueSet = true;
            System.out.println("Send " + n);
            notify();
        }
    }
}


    class Producer implements Runnable {
        Q q;

        Producer(Q q) {
            this.q = q;
            new Thread(this, "Supplier").start();
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                q.put(i++);
            }
        }
    }

    class Consumer implements Runnable {
        Q q;

        Consumer(Q q) {
            this.q = q;
            new Thread(this, "Consumer").start();
        }

        @Override
        public void run() {
            while (true) {
                q.get();
            }
        }
    }




