package com.knubisoft.booktasks_shildt_forBegginers_7th_2019;

// Упражнение 6 . 3 . Простая версия класса 1 1 реализующего быструю сортировку
class Quicksort {
    // Вызов фактического метода быстрой Quicksort,сортировки
    static void qsort(char[] items) {
        qs(items, 0, items.length - 1);
    }

    // Рекурсивная версия метода быстрой сортировки символов
    private static void qs(char[] items, int left, int right) {
        int i, j;
        char x, y;
        i = left;
        j = right;
        x = items[(left + right) / 2];
        do {
            while ((items[i] < x) && (i < right)) i++;
            while ((x < items[j]) && (j > left)) j--;
            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }
}

class QSDemo {
    public static void main(String[] args) {
        char[] a = {'d', 'х', 'а', 'r', 'р', 'j', 'i'};
        int i;
        System.out.print("Иcxoдный массив: ");
        for (i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println();
        // Сортировка массива
        Quicksort.qsort(a);
        System.out.print("Oтcopтиpoвaнный массив: ");
        for (i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }
}

