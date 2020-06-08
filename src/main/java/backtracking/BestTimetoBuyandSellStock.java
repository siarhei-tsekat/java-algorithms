package backtracking;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        System.out.println("Expected: 5. Actual: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Expected: 8. Actual: " + maxProfit(new int[]{7, 10, 2, 10, 1, 2}));
        System.out.println("Expected: 9. Actual: " + maxProfit(new int[]{7, 10, 1, 10, 3, 0}));
        System.out.println("Expected: 0. Actual: " + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int bestToBuy = Integer.MAX_VALUE;
        int bestToSell = 0;
        int bestProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < bestToBuy) {
                bestToBuy = prices[i];
                bestToSell = 0;
            } else if (prices[i] > bestToSell) {
                bestToSell = prices[i];
            }
            bestProfit = Math.max(bestProfit, checkProfit(bestToBuy, bestToSell));
        }
        return bestProfit;
    }

    private static int checkProfit(int bestToBuy, int bestToSell) {
        if (bestToBuy < bestToSell) return bestToSell - bestToBuy;
        else return 0;
    }
}
