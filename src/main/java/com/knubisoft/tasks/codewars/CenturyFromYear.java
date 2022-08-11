package com.knubisoft.tasks.codewars;

public class CenturyFromYear {
    public static int getCentury(int year) {
        // WRITE YOUR CODE BELOW THIS LINE
        int century;
        if (year % 100 == 0){
            century = year / 100;
        } else {
            century = year / 100 +1;
        }
        return century;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static void main(String[] args) {
        getCentury(1705); // 18
        getCentury(1900); // 19
        getCentury(1601); // 17
        getCentury(2000); // 20
    }
}
