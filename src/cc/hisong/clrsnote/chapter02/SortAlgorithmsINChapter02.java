package cc.hisong.clrsnote.chapter02;

import java.util.Random;

public class SortAlgorithmsINChapter02 {

    /**
     * insertion sort algorithm in chapter 2 of clrs
     * @param arr an array of integer which is to be sorted
     */
    public static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i =1, key; i < length; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void testInsertionSort(int arraySize) {
        int[] arr = (new Random()).ints(arraySize).toArray();
        long start = System.nanoTime();
        insertionSort(arr);
        for (int i = 1; i < arraySize; i++) {
            if (arr[i] < arr[i - 1]) throw new AssertionError();
        }
        long end = System.nanoTime();
        System.out.println("test on insertion sort pass in "+(end - start));
    }

    /**
     * exercise 2.1-2 in chapter of clrs
     * @param arr an array of integer which is to be sorted
     */
    public static void insertionSortDescending(int[] arr) {
        int length = arr.length;
        for (int i = 1, key; i < length; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && key > arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void testInsertionSortDescending(int arraySize) {
        int[] arr = (new Random()).ints(arraySize).toArray();
        long start = System.nanoTime();
        insertionSortDescending(arr);
        for (int i = 1; i < arraySize; i++) {
            if (arr[i] > arr[i - 1]) throw new AssertionError();
        }
        long end = System.nanoTime();
        System.out.println("test on descending insertion sort pass in "+(end - start));
    }

    /**
     * exercise 2.1-3 in chapter of clrs
     * @param arr the array in which to find v
     * @param value the value to find
     * @return
     */
    public static Integer linearSearch(int[] arr, int value) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static void testLinearSearch(int arraySize) {
        int[] arr = (new Random()).ints(arraySize).toArray();
        long start = System.nanoTime();
        for (int i = 0; i < arraySize; i++) {
            if (arr[linearSearch(arr, arr[i])] != arr[i]) throw new AssertionError();
        }
        long end = System.nanoTime();
        System.out.println("test on linear search pass in "+(end - start));
    }
}