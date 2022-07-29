package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;
//Shildt book Lambda examples

public class TestLambda {
    public static void main(String[] args) {
        //() -> 98.6
        //() -> Math.random() * 100
        //(n) -> 1.0 / n;
        //(n) -> (n % 2) == 0;
        //n -> (n % 2) == 0;
        MyValue myVal;
        myVal = () -> 98.6;
        // in one sentence MyValue myVal = () -> 98.6;
        System.out.println("Постійне значення: " + myVal.getValue());

        MyParamValue myPval = (n) -> 1.0 / n;
        System.out.println("Значення, зворотнє значенню 4 дорівнює " + myPval.getValue(4.0));

        System.out.println("Значення, зворотнє значенню 8 дорівнює " + myPval.getValue(8.0));

        //myVal = () -> "three"; //помилка, тип String не сумісний с типом double
        //myVal = () -> Double.parseDouble("three");
        //System.out.println(myVal.getValue()); // NumberFormatException
        //myPval = () -> Math.random(); //помилка, необхідний параметр




    }
}
