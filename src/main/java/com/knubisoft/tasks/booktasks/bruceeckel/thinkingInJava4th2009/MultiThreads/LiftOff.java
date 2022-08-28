package com.knubisoft.tasks.booktasks.bruceeckel.thinkingInJava4th2009.MultiThreads;

public class LiftOff implements Runnable {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff(20);
        liftOff.run();

    }
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "). ";
    }
    @Override
    public void run() {
        while (countDown--> 0){
            System.out.println(status());
            Thread.yield();
        }

    }
}
