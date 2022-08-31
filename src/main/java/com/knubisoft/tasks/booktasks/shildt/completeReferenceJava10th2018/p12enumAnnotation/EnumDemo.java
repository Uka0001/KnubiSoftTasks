package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p12enumAnnotation;

public class EnumDemo {
    public static void main(String[] args) {
        Apple apple;
        apple = Apple.Cortland;
        System.out.println("Value: " + apple);
        System.out.println();

        apple = Apple.Jonathan;
        System.out.println("Value: " + apple);
        System.out.println();

        if (apple == Apple.Jonathan) {
            System.out.println(
                    "True Value is: " + apple + "\n");
        }
        switch (apple){
                case Jonathan:
                    System.out.println("Value has next value: " +  apple + "\n");
                    break;
                case GoldenDel:
                    System.out.println("Value has next value: " +  apple + "\n");
                    break;
                case RedDel:
                    System.out.println("Value has next value: " +  apple + "\n");
                    break;
                case Winesap:
                    System.out.println("Value has next value: " +  apple + "\n");
                    break;
                case Cortland:
                    System.out.println("Value has next value: " +  apple + "\n");
                    break;
        }
    }
}
