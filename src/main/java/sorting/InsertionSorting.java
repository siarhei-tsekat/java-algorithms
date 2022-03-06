package sorting;

import java.util.Arrays;

public class InsertionSorting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 8, 3, 1, 4, 9, 2, 4, 0})));
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(sort(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(sort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sort(new int[]{0})));
        System.out.println(Arrays.toString(sort(new int[]{9})));
    }

    // n * n
    public static int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int j = i;

            while (j - 1 >= 0 && arr[j] < arr[j - 1]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }

        return arr;
    }
}
