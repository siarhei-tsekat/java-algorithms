package dynamicProgramming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int indexOfLastElementInArr = 0;

        for (int num : nums) {

            int tmpIndexInArr = 0;

            while (tmpIndexInArr < indexOfLastElementInArr) {
                if (arr[tmpIndexInArr] >= num) {
                    break;
                }
                tmpIndexInArr++;
            }
            arr[tmpIndexInArr] = num;
            if (tmpIndexInArr == indexOfLastElementInArr) indexOfLastElementInArr++;
        }
        return indexOfLastElementInArr;
    }
}

class Run {
    public static void main(String[] args) {
//        int[] var = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] var = {4, 10, 4, 3, 8, 9};
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        System.out.println(subsequence.lengthOfLIS(var));
    }
}
