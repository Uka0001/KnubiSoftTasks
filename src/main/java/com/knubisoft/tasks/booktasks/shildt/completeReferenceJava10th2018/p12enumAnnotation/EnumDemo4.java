package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p12enumAnnotation;

public class EnumDemo4 {
    public static void main(String[] args) {
        Apple apple, apple1, apple2, apple3;

        //получить все порядковые значения
        //с помощью метода ordinal()

        System.out.println("все порядковые значения сортов"
                + " яблок и их порядковые значения:");

        for (Apple each: Apple.values()){
            System.out.println(each + " " + each.ordinal());
        }

        apple = Apple.Jonathan;
        apple1 = Apple.Cortland;
        apple3 = Apple.Jonathan;

        //продемонстрировать применение
        //методов compareTo() и equals()

        if (apple.compareTo(apple1) < 0) {
            System.out.println(apple + " предшествует " + apple1);
        } else if (apple.compareTo(apple3) == 0) {
                System.out.println(apple + " равно " + apple1);
        } else {
            System.out.println(apple1 + " предшествует " + apple);
        }

        System.out.println();

        if (apple.equals(apple1))
            System.out.println(apple + " Oшибкa! " + apple1);

        if (apple.equals(apple3))
            System.out.println(apple + " равно " + apple3);

        if (apple == apple3)
            System.out.println(apple + " == " + apple3);




    }
}
