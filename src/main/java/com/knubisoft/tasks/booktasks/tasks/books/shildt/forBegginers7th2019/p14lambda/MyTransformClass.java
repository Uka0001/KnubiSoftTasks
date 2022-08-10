package com.knubisoft.tasks.booktasks.tasks.books.shildt.forBegginers7th2019.p14lambda;

public class MyTransformClass {
    public static void main(String[] args) {
        MyTransform<Double>sqrt = (v) -> {
            for (int i=0; i<v.length; i++) v[i] = Math.sqrt(v[i]);
        };
    }
}
