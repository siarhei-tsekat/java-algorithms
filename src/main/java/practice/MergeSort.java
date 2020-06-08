package practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] original = {1, 8, 2, 3, 4, 6};
        int[] sorted = {1, 2, 3, 4, 6, 8};
        System.out.println("Expected: true. Actual: " + Arrays.equals(sorted, mergeSort(original)));
        System.out.println(Arrays.toString(mergeSort(original)));
    }

    public static int[] mergeSort(int[] input) {
        return null;
    }
}

