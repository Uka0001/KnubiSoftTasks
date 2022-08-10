package com.knubisoft.tasks.test;

public class Beta extends Alpha {

    public Beta() {
        System.out.print("beta ");
    }

    public static void main(String[] args) {
        Beta beta = new Beta();
        beta.go();
    }

    void go() {
        type = "b ";
        System.out.print(this.type + super.type);
    }
}

class Alpha {
    public String type = "a ";

    public Alpha() {
        System.out.print("alpha ");
    }
}
