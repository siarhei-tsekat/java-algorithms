package array;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = getOne(nums1, nums2);

        if (arr.length % 2 == 0) {
            int left = arr.length / 2;
            int right = left-1;
            return (arr[left] + arr[right]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }

    private static int[] getOne(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int first = 0;
        int second = 0;
        int res = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                arr[res++] = nums1[first++];
            } else {
                arr[res++] = nums2[second++];
            }
        }
        while (first < nums1.length) {
            arr[res++] = nums1[first++];
        }

        while (second < nums2.length) {
            arr[res++] = nums2[second++];
        }

        return arr;
    }
}
