package com.knubisoft.tasks.algorithm.search;

public class SearchImpl implements Search{
    @Override
    public int binarySearch(long[] array, long v) {
            int low = 0;
            int high = array.length - 1;
            return recursive(array, low, high, v);
        }
        public int recursive(long[] array, int low, int high, long v) {
            if(low > high) return -1;
            int mid = (low + high) / 2;

            if(array[mid] == v) return mid;

            if(v > array[mid]) return recursive(array, mid + 1, high, v);
            else return recursive(array, low, mid - 1, v);
        }
        //alternative decision
    /*int n = array.length;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = low + high >> 1;
            if(array[mid] == v) return mid;
            if(array[mid] < v) low = mid + 1;
            else high = mid - 1;
        }
        return -1;*/
}
