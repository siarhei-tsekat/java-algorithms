package dynamicProgramming;

class R_unner {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
//        System.out.println("Expected: 11. Actual: " + new MinimumCostForTickets().mincostTickets(days, costs));
//        System.out.println("Expected: 17. Actual: " + new MinimumCostForTickets().mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, costs));
        System.out.println("Expected: 44. Actual: " + new MinimumCostForTickets().mincostTickets(new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28}, new int[]{3,13,45}));
    }
}

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        return 0;
    }
}
