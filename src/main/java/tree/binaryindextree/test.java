package tree.binaryindextree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test {

    @Test
    public void test1() {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);

        Assert.assertEquals(numArray.sumRange(0, 2), 9);

        numArray.update(1,2);
        Assert.assertEquals(numArray.sumRange(0, 2), 8);
    }

    @Test
    public void test2() {
        int[] nums = {-1, 3, -5};
        NumArray numArray = new NumArray(nums);

        Assert.assertEquals(numArray.sumRange(0, 2), -3);

        numArray.update(1,2);
        Assert.assertEquals(numArray.sumRange(0, 2), -4);
    }
}

