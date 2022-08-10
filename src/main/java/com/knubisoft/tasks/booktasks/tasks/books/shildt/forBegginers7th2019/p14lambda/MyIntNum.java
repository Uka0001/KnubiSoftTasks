package com.knubisoft.tasks.booktasks.tasks.books.shildt.forBegginers7th2019.p14lambda;

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


