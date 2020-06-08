package array.greedy;

public class MaximumSubarray {

    public  int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
class Runner {
    public static void main(String[] args) {
        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.maxSubArray(ints));

    }
}