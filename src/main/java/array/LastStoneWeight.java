package array;

import java.util.Arrays;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(nums));
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);


        for (int i = stones.length - 1; i > 0; i--) {
            if (stones[i] == stones[i  - 1]) {
                i--;
            }else if(stones[i] > stones[i - 1]){
                stones[i - 1] = stones[i] - stones[i - 1];
            }else {
                stones[i - 1] = stones[i - 1] - stones[i];
            }
        }
        System.out.println(Arrays.toString(stones));
        return stones[0];
    }
}
