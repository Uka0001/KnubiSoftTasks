package com.knubisoft.tasks.booktasks.tasks.books.shildt.forBegginers7th2019.p15modules.appfunc.simplefuncs;

public class SimpleMathFuncs {
//Определить, является ли а множителем Ь
    public static boolean isFactor(int a, int b){
        if ((b%a) == 0) return true;
        return false;
    }

    // Вернуть наименьший положительньй
    // общий множитель для а и b

    public static int lcf(int a, int b){
        // Вычисление множителя на основе положительных значений
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a<b ? a : b;

        for (int i = 2; i<=min/2; i++) {
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }

    public static int gcf(int a, int b){
        // Вычисление множителя на основе положительных значений
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a<b ? a : b;

        for (int i = min/2; i>=2; i--) {
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }
}
