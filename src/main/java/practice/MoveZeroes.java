package practice;

import java.util.Arrays;

/***
 * Given an array nums,
 * write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] var = new int[]{0, 1, 0, 3, 12};
        moveZeroes(var);
        System.out.println("Expected: [1,3,12,0,0]. Actual:" + Arrays.toString(var));
    }

    public static void moveZeroes(int[] nums) {

    }
}
