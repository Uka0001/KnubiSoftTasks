package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;

public class MethodRefDemo {
        //В данном методе типом первого параметра является
        //функциональный интерфейс. Следовательно, ему можно передать
        //ссыпку на любой экземпляр этого интерфейса, в том числе и на
        //экземпляр , созданный посредством ссылки на метод .
        static boolean numTest(IntPredicate p, int v){
            return p.test(v);
        }

        public static void main(String[] args) {
            boolean result;
            // Здесь методу numTest ( ) передается ссыпка
            // на метод isPrime()
            result = numTest(MyIntPredicates::isPrime, 17);
            if (result) System.out.println("17 is simple number");

            //Здесь методу numTest ( ) передается ссыпка
            //на метод isEven()
            result = numTest(MyIntPredicates::isEven, 12);
            if (result) System.out.println("12 is even number");

            //Здесь методу numTest ( ) передается ссыпка
            //на метод isPositive()
            result = numTest(MyIntPredicates::isPositive, 11);
            if (result) System.out.println("11 is positive number");
        }
}
