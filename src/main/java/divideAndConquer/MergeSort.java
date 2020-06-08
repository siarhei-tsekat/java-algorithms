package divideAndConquer;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{1, 8, 2, 3, 4, 6,})));
    }

    public static int[] mergeSort(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int medium = input.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(input, 0, medium));
        int[] right = mergeSort(Arrays.copyOfRange(input, medium, input.length));
        return sort(left, right);

    }

    private static int[] sort(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftCursor = 0;
        int rightCursor = 0;
        int resCursor = 0;

        while (leftCursor < left.length && rightCursor < right.length) {
            if (left[leftCursor] < right[rightCursor]) {
                res[resCursor++] = left[leftCursor++];
            } else {
                res[resCursor++] = right[rightCursor++];
            }
        }

        while (leftCursor < left.length){
            res[resCursor++]=left[leftCursor++];
        }

        while (rightCursor < right.length){
            res[resCursor++]=right[rightCursor++];
        }

        return res;
    }
}
