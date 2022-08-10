package com.knubisoft.tasks.booktasks.tasks.books.shildt.forBegginers7th2019.p14lambda;

public class VarCapture {
    public static void main(String[] args) {
        // Локальная переменная, которая может быть захвачена
        int num = 10;

        MyFunc myLambda = (n) -> {
            // Такое использование переменной num корректно,
            // поскольку ее значения не изменяется
            int v = num + n;

            // Приведенная ниже инструкция некорректна ,
            // поскольку она изменяет значение переменной num
            //num++;
            return v;
        };

        // Приведенная ниже инструкция некорректна ,
        // поскольку она изменяет значение переменной num
        System.out.println(myLambda.func(8));

        // Приведенная ниже строка породила бы ошибку, поскольку она
        // лишает num статуса финальной переменной
        // помилка компіляції - local variables referenced from a lambda expression must be final or effectively final
        //num = 9;
    }
}
