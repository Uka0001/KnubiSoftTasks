package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;

public class BlockLambdaDemo {
    public static void main(String[] args) {
        // блок лямбда вираз повертає
        // найменший позитивний делітель цілого числа
        NumericFunc smallestF = (n) -> {
            int result = 1;

            //absolute value of n
            n = n < 0 ? -n : n;

            for (int i = 2; i <n/i; i++)
                if((n%i)== 0) {
                    result = i;
                    break;
                }
            return  result;
        };
        System.out.println("Найменший ділитель 12 є " + smallestF.func(12));
        System.out.println("Найменший ділитель 11 є " + smallestF.func(11));
    }
}
