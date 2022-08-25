package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p11MultiThreading;

class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("For stop tap ctrl - c");
    }
}
