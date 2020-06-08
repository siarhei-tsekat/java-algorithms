package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static int[] var = {1, 2, 3};

    public static void main(String[] args) {
        System.out.println(subsets(var));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        func(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private static void func(int start, int[] nums, ArrayList<Integer> tmp, List<List<Integer>> res) {

        if (start == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[start]);
        func(start + 1, nums, tmp, res);
        tmp.remove(tmp.size() - 1);
        func(start + 1, nums, tmp, res);
    }
}

