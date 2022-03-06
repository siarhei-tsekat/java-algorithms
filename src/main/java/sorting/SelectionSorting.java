package sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 8, 3, 1, 4, 9, 2, 4, 0})));
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(sort(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(sort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sort(new int[]{0})));
        System.out.println(Arrays.toString(sort(new int[]{9})));
    }

    public static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }

        }

        return arr;
    }
}
