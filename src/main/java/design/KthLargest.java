package design;

import org.testng.Assert;

import java.util.PriorityQueue;

public class KthLargest {
    private final int k;
    PriorityQueue<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new PriorityQueue<>(k, (f, s) -> f - s);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            if (list.size() > k) {
                list.poll();
            }
        }
    }

    public int add(int val) {
        list.add(val);
        if (list.size() > k) {
            list.poll();
        }
        return list.peek();
    }
}

class R_unner {
    public static void main(String[] args) {
        int[] var = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, var);
        Assert.assertEquals(kthLargest.add(3), 4);
        Assert.assertEquals(kthLargest.add(5), 5);
        Assert.assertEquals(kthLargest.add(10), 5);
        Assert.assertEquals(kthLargest.add(9), 8);
        Assert.assertEquals(kthLargest.add(4), 8);
    }
}
