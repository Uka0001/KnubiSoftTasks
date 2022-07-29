package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;

public class LambdaDemo2 {
    public static void main(String[] args) {
        //визначимо чи є одна строка частиною іншої строки
        StringTest isIn = (a, b) -> a.indexOf(b) != -1;// - example from book
        //StringTest isIn = (a, b) -> a.contains(b); //Idea refactoring code
        //StringTest isIn = String::contains; //Idea refactoring code second time :)

        String str = "This is test";

        System.out.println("Test string" + str);

        if (isIn.test(str, "This"))
            System.out.println("'This' is found");
        else
            System.out.println("'This' not found");

        if (isIn.test(str, "und"))
            System.out.println("'und' is found");
        else
            System.out.println("'und' not found");
    }
}
