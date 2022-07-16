package com.knubisoft.base.arrays;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
        ArrayUtils.reverse(array);
        return array;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int a1 = array1.length;
        int b1 = array2.length;
        int[] mergedArray = new int[a1 + b1];
        System.arraycopy(array1, 0, mergedArray, 0, a1);
        System.arraycopy(array2, 0, mergedArray, a1, b1);
        System.out.println(Arrays.toString(mergedArray));
        return mergedArray;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        if (array.length >= 3) {
            Arrays.sort(array);
            int first = array[array.length - 1];
            int second = array[array.length - 2];
            int third = array[array.length - 3];
            return new int[]{first, second, third};
        } else {
            return array;
        }
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                count++;
            } else {
                if (array[i] > array[i - 1]) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                }
            }
        }
        return Math.max(result, count);
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {

        int sum;
        if (array.length > 2) {
            Arrays.sort(array);
            sum = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] != array[i + 1]) {
                    sum += array[i + 1];
                }
            }
        } else if (array.length > 1) {
            sum = array[0] + array[1];
        } else
            sum = 0;
        return sum;
        //        HashSet<Integer> hashSet = new HashSet<>();
//        int sum = 0;
//        for (int j : array) {
//            if (!hashSet.contains(j)) {
//                sum += j;
//                hashSet.add(j);
//            }
//        }
//        return sum;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] != 0)
                array[count++] = array[i];
        while (count < array.length)
            array[count++] = 0;
        return array;

    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            while (original == num) {
                original = original * 2;
            }
        }
        return original;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        //sort the array of strings and find the
        // common prefix of the first and last string of the sorted array
        // https://www.geeksforgeeks.org/longest-common-prefix-using-sorting/
        int size = words.length;
        /* if size is 0, return empty string */
        if (size == 0)
            return "";
        if (size == 1)
            return words[0];
        /* sort the array of strings */
        Arrays.sort(words);
        /* find the minimum length from first and last string */
        int end = Math.min(words[0].length(), words[size - 1].length());
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && words[0].charAt(i) == words[size - 1].charAt(i))
            i++;
        return words[0].substring(0, i);
    }

    @Override
    public int missingNumber(int[] array) {
        // formula - sumTotal= n*(n+1)/2
        int n = array.length;
        int sum = n * (n + 1) / 2;
        for (int j : array) sum -= j;
        return sum;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        /*for (int i = 0; i < array.length-1; i++) {
            int j = i+1;
                if (array[i] == array[j]) {
                    return true;
                }
        }
        return false;*/

        // Creates an empty hashset
        Set<Integer> set = new HashSet<>();
        for (int j : array) {
            if (set.contains(j)) {
                return true;
            } else {
                set.add(j);
            }
        }
        return false;
    }
}
