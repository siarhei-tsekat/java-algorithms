//package design;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class RangeSumQueryMutable {
//    @Test
//    public void test() {
//        int[] nums = {1, 3, 5};
//        NumArray array = new NumArray(nums);
//
//        Assert.assertEquals(array.sumRange(0, 2), 9);
//
//        array.update(1, 2);
//        Assert.assertEquals(array.sumRange(0, 2), 8);
//    }
//}
//
//class NumArray {
//
//    int MAX = 1000;
//    int BITree[] = new int[MAX];
//
//    public NumArray(int[] nums) {
//        constructBIT(nums);
//    }
//
//    private void constructBIT(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            updateBIT(i, nums[i], nums.length);
//        }
//    }
//
//    private void updateBIT(int index, int val, int length) {
//        index++;
//        while (index <= length) {
//            BITree[index] += val;
//            index += index & (-index);
//        }
//    }
//
//
//    public int sumRange(int i, int j) {
//        int res = 0;
//        for (int k = i; k <= j; k++) {
//            res += nums[k];
//        }
//        return res;
//    }
//
//    public void update(int i, int val) {
//        nums[i] = val;
//    }
//}