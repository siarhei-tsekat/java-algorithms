package divideAndConquer;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,0,2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    private static void helper(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            helper(arr, start, partition - 1);
            helper(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int startCopy = start;
        for (int i = start; i < end; ++i) {
            if (arr[i] < pivot) {
                int tmp = arr[startCopy];
                arr[startCopy] = arr[i];
                arr[i] = tmp;
                startCopy++;
            }
        }
        int tmp = arr[startCopy];
        arr[startCopy] = arr[end];
        arr[end] = tmp;
        return startCopy;
    }
}
