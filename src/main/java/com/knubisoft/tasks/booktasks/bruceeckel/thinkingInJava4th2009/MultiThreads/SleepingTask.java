package com.knubisoft.tasks.booktasks.bruceeckel.thinkingInJava4th2009.MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    public void run(){
        try {
            while (countDown-->0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            service.execute(new SleepingTask());
        }
        service.shutdown();
    }
}
