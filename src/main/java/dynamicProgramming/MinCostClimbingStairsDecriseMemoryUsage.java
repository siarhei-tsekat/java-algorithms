package dynamicProgramming;

public class MinCostClimbingStairsDecriseMemoryUsage {
    public static void main(String[] args) {
        System.out.println(f(new int[]{10, 15, 20}));
    }

    private static int f(int[] steps) {
        int s0 = 0;
        int s1 = 0;
        for (int i = 0; i < steps.length; i++) {
            int tmp = steps[i] + Math.min(s0, s1);
            s1 = s0;
            s0 = tmp;
        }
        return Math.min(s0, s1);
    }
}
