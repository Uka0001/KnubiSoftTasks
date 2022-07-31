package com.knubisoft.booktasks_shildt_forBegginers_7th_2019.p14_lambda;

public class MyIntNum {
    private int v;

    MyIntNum(int x) {
        v = x;
    }

    int getNum(){
        return v;
    }

    // Вернуть true, если n - делитель v
    boolean isFactor(int n){
        return (v%n)==0;
    }
}


