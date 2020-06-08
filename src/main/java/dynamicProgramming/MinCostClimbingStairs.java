package dynamicProgramming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(f(new int[]{10, 15, 20}));
    }

    private static int f(int[] steps) {
        int length = steps.length;
        int[] tmp = new int[length];
        tmp[0] = steps[0];
        tmp[1] = steps[1];
        for (int i = 2; i < length; i++) {
            tmp[i] = steps[i] + Math.min(tmp[i - 1], tmp[i - 2]);
        }
        return Math.min(tmp[length - 1], tmp[length - 2]);
    }
}
