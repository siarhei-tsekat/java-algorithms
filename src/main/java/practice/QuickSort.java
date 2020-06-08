package practice;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] original = {5, 9, 1, 6};
        int[] sorted = {1, 5, 6, 9};
        quickSort(original);
        System.out.println("Expected: true. Actual: " + Arrays.equals(sorted, original));
        System.out.println(Arrays.toString(original));
    }

    public static void quickSort(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    private static void helper(int[] arr, int start, int end) {

    }

}

