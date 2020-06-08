package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Ru_nner {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsWithDuplicates subsets = new SubsetsWithDuplicates();
        System.out.println(subsets.subsetsWithDup(nums));
    }
}


public class SubsetsWithDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        func(0, nums.length ,nums, new ArrayList<>(), lists, new HashSet<List<Integer>> (), new HashSet<Integer> ());
        return lists;
    }

    private void func(int start, int end ,int[] nums, ArrayList<Integer> tmp, List<List<Integer>> res,HashSet<List<Integer>> set,HashSet<Integer> set2) {
        if (start > nums.length) return;

        if (tmp.size() == start) {
            if (set.add(new ArrayList<>(tmp))) res.add(new ArrayList<>(tmp));
        }

        for (int i = start; i < end; i++) {
            tmp.add(nums[i]);
            func(start + 1, end  , nums, tmp, res, set, set2);
            tmp.remove(tmp.size() - 1);
        }
    }
}
