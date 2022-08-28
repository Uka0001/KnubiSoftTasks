package com.knubisoft.tasks.booktasks.bruceeckel.thinkingInJava4th2009.MultiThreads;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result TaskWithResult " + id;
    }
}
