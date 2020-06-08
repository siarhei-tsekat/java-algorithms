package array;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 0, 2}));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res += calculate(left, right, height);
            if (height[left] > height[right])
                right--;
            else left++;
        }
        return res;
    }

    private static int calculate(int left, int right, int[] height) {
        int res = 0;
        int leftV = height[left];
        int rightV = height[right];
        int pivot = leftV < rightV ? leftV : rightV;
        for (int i = left + 1; i < right; i++) {
            int result = height[i] < pivot ? pivot - height[i] : -1;
            if (result > 0) {
                height[i] = height[i] + result;
                res += result;
            }
        }
        return res;
    }
}
