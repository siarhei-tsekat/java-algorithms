package xor;


/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("2 => " + new Solution().missingNumber(new int[]{3, 0, 1}));
        System.out.println("2 => " + new Solution().missingNumber(new int[]{0, 1}));
        System.out.println("8 => " + new Solution().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            res = res ^ i;
        }

        return res;
    }
}
