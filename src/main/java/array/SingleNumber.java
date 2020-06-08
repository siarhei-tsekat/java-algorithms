package array;

public class SingleNumber {
    public static void main(String[] args) {
        int[] var = {2, 2, 1};
        int[] var2 = {4,1, 2, 1, 2};
        System.out.println("Expected: 1. Actual: " + singleNumber(var));
        System.out.println("Expected: 4. Actual: " + singleNumber(var2));
    }

    private static int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
