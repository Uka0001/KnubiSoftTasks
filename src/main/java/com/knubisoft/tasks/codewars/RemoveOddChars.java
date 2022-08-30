package com.knubisoft.tasks.codewars;

public class RemoveOddChars {
    public static String removeOddChars(String originalString) {
        // write your code below this line
        char [] charArr = originalString.toCharArray();
        String result = "";
        if(charArr.length == 0 | charArr == null){
            result = "";
        } else{
            for(int i = 0; i < charArr.length; i++){
                if (i % 2 == 0){
                    result = result + Character.toString(charArr[i]);
                }else{
                    continue;
                }
            }
        }
        return result;
        // write your code above this line
    }
}
/*В цьому завданні реалізуй метод removeOddChars(), який приймає рядок і видаляє в ньому всі непарні символи, а потім повертає результат.

Зверни увагу: непарні символи у рядку розташовані на непарних індексах.

Наприклад:

removeOddChars("hello"); // "hlo"
// 'e' та 'l' було видалено,
// бо вони знаходяться на індексах 1 і 3

removeOddChars("1234"); // "13"
removeOddChars("(())"); // "()"
removeOddChars("Bob"); // "Bb"
removeOddChars(""); // ""
*/
