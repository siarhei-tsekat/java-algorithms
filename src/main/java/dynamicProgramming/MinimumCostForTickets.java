package dynamicProgramming;

class R_unner {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        MinimumCostForTickets cost = new MinimumCostForTickets();
        System.out.println("Expected: 11. Actual: " + cost.mincostTickets(days, costs));
    }
}

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        return 0;
    }

}
