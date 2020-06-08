package array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                result = Math.max(result, calculate(height[left], right - left));
                left++;
            } else {
                result = Math.max(result, calculate(height[right], right - left));
                right--;
            }
        }
        return result;
    }

    private static int calculate(int height, int distance) {
        return height * distance;
    }
}
