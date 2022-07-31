package com.knubisoft.booktasks.shildt.forBegginers7th2019.p14lambda;

public class MethodRefDemo2 {
    public static void main(String[] args) {
        boolean result;

        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);

        // Создать ссыпку ip на метод isFactor объекта myNum
        //Ссылка нa метод

        IntPredicate ip = myNum::isFactor;

        // Использовать ссыпку для: вызова метода isFactor ( )
        // через метод test()

        result = ip.test(3);
        if (result) System.out.println("З является делителем " + myNum.getNum());

        // Создать ссылку на метод isFactor для: объекта myNum2
        // и использовать ее для: вызова метода isFactor ( )
        //через метод test()

        ip = myNum2::isFactor;
        result = ip.test(3);
        if (!result) System.out.println("З не является делителем " + myNum2.getNum());
    }
}
