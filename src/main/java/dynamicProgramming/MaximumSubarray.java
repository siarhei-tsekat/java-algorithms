package dynamicProgramming;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("6 => " + new Solutio_n_().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

class Solutio_n_ {
    public int maxSubArray(int[] nums) {
        int totalMax = nums[0];
        int localMax = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            localMax = Math.max(localMax + nums[i + 1], nums[i + 1]);
            totalMax = Math.max(totalMax, localMax);
        }
        return totalMax;
    }
}
