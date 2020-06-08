package array;

import java.util.TreeSet;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        System.out.println(twoSumLessThanK(generate(), 15));
    }

    private static int[] generate() {
        int size = 100;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static int twoSumLessThanK(int[] arr, int target) {
        int res = -1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val >= target) {
                continue;
            }
            Integer higher = set.higher(val);
            if (higher != null) {
                int total = val + (target - higher);
                if (total < target) res = Math.max(res, total);
            }
            set.add(target - val);
        }
        return res;
    }
}
