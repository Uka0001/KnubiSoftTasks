package com.knubisoft.tasks.codewars;

public class GetMiddleCharacter {
    public static String getMiddleString(String originalString) {
        // write your code below this line
        char [] charArr = originalString.toCharArray();
        String result = null;
        if(charArr.length == 0 | charArr == null){
            result = "";
        } else if (charArr.length % 2 == 0){
            int one = charArr.length/2-1;
            int two = charArr.length/2;
            result = Character.toString(charArr[one]) + Character.toString(charArr[two]);
        }else{
            int one = charArr.length/2;
            result = Character.toString(charArr[one]);
        }
        return result;
        // write your code above this line
    }
}
/*Згадаємо як знаходити символи в рядку.

У цьому завданні реалізуй метод getMiddleString(), що приймає рядок і повертає центральний символ у вигляді рядку.

Зверни увагу: якщо довжина рядка парна, поверни два центральних символи.

Наприклад:

getMiddleString("hello"); // "l"
getMiddleString("1234"); // "23"
getMiddleString("(())"); // "()"
getMiddleString("Bob"); // "o"
getMiddleString(""); // ""



Розв'язок ментора
Розв'язок буде доступний після вирішення завдання. Або завт*/
