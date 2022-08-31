package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p12enumAnnotation;

public class EnumDemo2 {
    public static void main(String[] args) {
        Apple apple;
        System.out.println("Константы перечислимого типа A p p l e : " );

        Apple [] apples = Apple.values();
        int i = 1;
        for(Apple each: apples){
            System.out.println("Value No " + i + " : " + each);
            i++;
        }
        System.out.println();
        i = 1;
        for(Apple each: Apple.values()){
            System.out.println("Value No " + i + " : " + each);
            i++;
        }
    }
}
