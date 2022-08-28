package com.knubisoft.tasks.booktasks.bruceeckel.thinkingInJava4th2009.MultiThreads;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++){
            results.add(service.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs: results){
            try{
                System.out.println(fs.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                service.shutdown();
            }
        }
    }
}
