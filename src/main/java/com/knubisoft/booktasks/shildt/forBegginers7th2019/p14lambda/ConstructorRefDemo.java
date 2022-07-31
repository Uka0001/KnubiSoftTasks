package com.knubisoft.booktasks.shildt.forBegginers7th2019.p14lambda;

public class ConstructorRefDemo {
    public static void main(String[] args) {
        // Создать ссылку на конструктор MyClass .
        // Поскольку метод func ( ) интерфейса MyFunc
        // имеет аргумент, new ссылается на параметризованный
        // конструктор MyClass , а не на конструктор по умолчанию .
        MyFunk2 myClassCons = MyClass::new;

        //Створтити екземпляр шляхом ссилки на конструктор
        MyClass mc = myClassCons.func("Testing");

        //використати тільки що створений екземпляр
        System.out.println("Cтpoкa str в mc: " + mc.getStr());
    }
}
