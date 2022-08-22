package com.knubisoft.tasks.codewars;

public class Solution1 {

    public static boolean check(Object[] a, Object x) {
        for (int i = 0; i < a.length; i++) {
            if(x == a[i]){
                return true;
            }
        }
        return false;

        //best practice and clever from code wars
        //return Arrays.asList(a).contains(x);


//        if (x )
//        String[] values = (String[]) a;
//        boolean contains = Arrays.stream(values).anyMatch(x::equals);

//        boolean result = false;
//        for(Object each: a){
//            if(isInteger((String) each) & isInteger((String) x) & each == x){
//                result = true;
//                //return result;
//            }else if (!isInteger((String) each) & !isInteger((String) x) & ((String) each).toUpperCase().equals(((String) x).toUpperCase())) {
//                result = true;
//                // return result;
//            }
////            } else {
////                result = false;
////                //return result;
////            }
//            // return result;
//        }
//        return result;
//    }
//
//    public static boolean isInteger(String s) {
//        try {
//            Integer.parseInt(s);
//        } catch(NumberFormatException e) {
//            return false;
//        }
//        // only got here if we didn't return false
//        return true;
//    }
 //       return false;
    }
}
//You will be given an array a and a value x.
// All you need to do is check whether the
// provided array contains the value.
//Array can contain numbers or strings. X can be either.
//Return true if the array contains the value, false if not.
