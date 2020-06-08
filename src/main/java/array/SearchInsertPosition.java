package array;

/***
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("Expected: 2. Actual: " + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("Expected: 1. Actual:  " + searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public static int searchInsert(int[] nums, int target) {

        return func(0, nums.length - 1, target, nums);
    }

    public static int func(int start, int end, int target, int[] nums) {
        if (start > end) return start;

        int mid = (start + end) >>> 1;

        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) return func(mid + 1, end, target, nums);
        else return func(start, mid - 1, target, nums);
    }
}
