package practice;

import java.util.Arrays;
import java.util.HashMap;

/***
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] var = {2, 7, 11, 15};
        System.out.println("Expected: [0,1]. Actual: " + Arrays.toString(twoSum(var, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
        }
        return res;
    }
}
