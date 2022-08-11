package com.knubisoft.tasks.codewars;

public class GetAverageSalary {
    public static double getAverageSalary(double[] salaries) {
        // write your code below this line
        double sum = 0.0;
        if (salaries == null | salaries.length == 0) {
            return 0.000000;
        } else{
            for (double each : salaries) {
                sum += each;
            }
            return sum / salaries.length;
        }
        // write your code above this line
    }

    public static void main(String[] args) {
        getAverageSalary(new double[] {1000.00, 500.00}); // 750.00
        getAverageSalary(new double[] {100.00, 200.00, 300.00}); // 200.00
        getAverageSalary(new double[0]); // 0.00
    }
}
