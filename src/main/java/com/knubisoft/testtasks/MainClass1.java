package com.knubisoft.testtasks;

public class MainClass1 {

        public static void main(String[] args) {
            Integer numA = 0;
            incrementNumber(numA);
            numA = numA * 2;
            System.out.println(numA);
        }

        private static void incrementNumber(Integer numP) {
            numP++;
            Integer numA = 42;
        }
    }
