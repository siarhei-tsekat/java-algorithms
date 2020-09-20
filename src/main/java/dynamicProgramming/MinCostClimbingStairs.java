package dynamicProgramming;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println("15 => " + f(new int[]{10, 15, 20}));
        System.out.println("6 => " + f(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    private static int f(int[] cost) {
        int dp[] = new int[cost.length + 2];

        for (int i = 0, j = 2; i < cost.length - 1; i++, j++) {
            dp[j] =  Math.min(cost[i] + dp[j - 2], cost[i + 1] + dp[j - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 2];
    }

//    private static int f(int[] steps) {
//        int length = steps.length;
//        int[] tmp = new int[length];
//        tmp[0] = steps[0];
//        tmp[1] = steps[1];
//        for (int i = 2; i < length; i++) {
//            tmp[i] = steps[i] + Math.min(tmp[i - 1], tmp[i - 2]);
//        }
//        return Math.min(tmp[length - 1], tmp[length - 2]);
//    }
}
