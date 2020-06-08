package dynamicProgramming;

public class BestTimetoBuyandSellStockwithTransactionFee {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("8 = > " + solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}

class Solution {
    public int maxProfit(int[] pr, int fee) {

        int profit = 0;
        int balancce = -pr[0];

        for (int i = 1; i < pr.length; i++) {
            profit = Math.max(profit, pr[i] + balancce - fee);
            balancce = Math.max(balancce, profit - pr[i]);
        }

        return profit;
    }
}
