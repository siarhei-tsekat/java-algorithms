package dynamicProgramming;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[][] dp = new int[2][nums.length];
        dp[0][1] = nums[0];
        dp[1][1] = nums[1];

        for (int i = 2; i < dp[0].length; i++) {
            dp[0][i] = Math.max(dp[0][i - 2] + nums[i - 1], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + nums[i], dp[1][i - 1]);
        }

        return Math.max(dp[0][dp[0].length - 1], dp[1][dp[0].length - 1]);
    }
}

class Runner {
    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
//        System.out.println("3 = > " + houseRobberII.rob(new int[]{2, 3, 2}));
        System.out.println("4 = > " + houseRobberII.rob(new int[]{1,2, 3, 1}));
    }
}
