package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;

public class MyTransformClass {
    public static void main(String[] args) {
        MyTransform<Double>sqrt = (v) -> {
            for (int i=0; i<v.length; i++) v[i] = Math.sqrt(v[i]);
        };
    }
}
