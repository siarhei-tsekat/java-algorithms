package dynamicProgramming;

import java.util.Arrays;

/***
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

class Runer {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] nums = {1, 2, 5};
        int[] nums2 = {2};
        int[] nums3 = {1, 2147483647};
        int[] nums4 = {186, 419, 83, 408};
        System.out.println("3 => " + coinChange.coinChange(nums, 11));
        System.out.println("-1 => " + coinChange.coinChange(nums2, 3));
        System.out.println("2 => " + coinChange.coinChange(nums3, 2));
        System.out.println("20 => " + coinChange.coinChange(nums4, 6249));
    }
}
