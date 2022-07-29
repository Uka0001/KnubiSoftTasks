package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;

public class LambdaDemo {
    public static void main(String[] args) {
        NumericTest isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2))
            System.out.println("2 не є ділитилем 10");
        if (!isFactor.test(10, 3))
            System.out.println("3 не є ділителем 10");
        System.out.println();

        //true if 1st arg less than 2nd arg
        NumericTest lessThan = (n, m) -> (n < m);

        if (lessThan.test(2, 10))
            System.out.println("2 less than 10");
        if(!lessThan.test(10, 2))
            System.out.println("10 not less than 2");
        System.out.println();

        //true if args are equal for absolute value
        NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m<0 ? -m : m);

        if (absEqual.test(4, -4))
            System.out.println("Absolute value 4 and -4 are equal");
        if (!lessThan.test(4, -5))
            System.out.println("Absolute value 4 and -5 not equal");
        System.out.println();
    }
}
