package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p12enumAnnotation;

public class EnumDemo3 {
    public static void main(String[] args) {
        
        //вывести цену на яблоко сорта Winesap
        System.out.println("Яблoкo сорта Winesap стоит: "
                + AppleNumbers.WINESON.getPrice() + " центов.");

        // вывести цены на все сорта яблок
        System.out.println("Ціни на всі сорта яблук: ");
        for(AppleNumbers each: AppleNumbers.values()){
            System.out.println("Цінa " + each.toString().toLowerCase() + " = "
                    + each.getPrice() + " центов.");
        }
    }
}
