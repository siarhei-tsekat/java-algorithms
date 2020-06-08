package backtracking;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] var = {3, 0, -2, -1, 1, 2};
//        int[] var = {12,13,-10,-15,4,5,-8,11,10,3,-11,4,-10,4,-7,9,1,8,-5,-1,-9,-4,3,-14,-11,14,0,-8,-6,-2,14,-9,-4,11,-8,-14,-7,-9,4,10,9,9,-1,7,-10,7,1,6,-8,12,12,-10,-7,0,-9,-3,-1,-1,-4,8,12,-13,6,-7,13,5,-14,13,12,6,8,-2,-8,-15,-10,-3,-1,7,10,7,-4,7,4,-4,14,3,0,-10,-13,11,5,6,13,-4,6,3,-13,8,1,6,-9,-14,-11,-10,8,-5,-6,-7,9,-11,7,12,3,-4,-7,-6,14,8,-1,8,-4,-11};
        Solution solution = new Solution();
        System.out.print("[[-2,-1,3],[-2,0,2],[-1,0,1]] == ");
        System.out.println(solution.threeSum(var));
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {

        func(0, nums, new ArrayList<>(), new int[1]);
        return res;
    }

    public void func(int start, int[] nums, ArrayList<Integer> tmp, int []st) {

        if (tmp.size() > 3) return;

        if (tmp.size() == 3 && st[0]== 0) {
            if (!contains(tmp)) res.add(new ArrayList<>(tmp));
        }

        for (int i = start; i < nums.length; i++) {
            st[0]+=nums[i];
            tmp.add(nums[i]);
            func(i + 1, nums, tmp,st);
            tmp.remove(tmp.size() - 1);
            st[0]-=nums[i];
        }
    }

    public boolean contains(ArrayList<Integer> tmp) {
        ArrayList<Integer> list = new ArrayList<>(tmp);
        Collections.sort(list);
        return !set.add(list);
    }
}
