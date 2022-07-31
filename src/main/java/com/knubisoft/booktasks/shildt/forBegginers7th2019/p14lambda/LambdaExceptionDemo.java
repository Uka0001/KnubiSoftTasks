package com.knubisoft.booktasks.shildt.forBegginers7th2019.p14lambda;

public class LambdaExceptionDemo {
    public static void main(String[] args) {
        double [] values = {1.0, 2.0, 3.0, 4.0};

        // Данное блочное лямбда-выражение может генерировать
        // исключение IOException. Следовательно, это исключение
        // должно быть указано в спецификации throws метода
        // ioAction ( ) функционального интерфейса MyIOAction .

        MyIOAction myIO = rdr -> {
            int ch = rdr.read();
            //может генерировать
            //исключение IOException
            //....
            return true;
        };
    }
}
