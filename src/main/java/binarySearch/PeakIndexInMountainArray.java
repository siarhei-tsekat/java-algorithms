package binarySearch;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while ((left < right) &&
                arr[left] < arr[left + 1] &&
                arr[right] < arr[right - 1]) {
            left++;
            right--;
        }

        return arr[left] < arr[right] ? right : left;
    }
}