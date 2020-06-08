package array.greedy;

public class BestTimeoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int currSum = 0;
        int maxSumm = 0;

        for(int i = 0; i < n-1; i+=2){
            currSum = Math.max(prices[i+1] - prices[i], currSum);
            maxSumm+= currSum;
            currSum = 0;
        }
        return maxSumm;
    }
}
