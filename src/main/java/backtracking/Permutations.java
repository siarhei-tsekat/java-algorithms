package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> target = createTarget();
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println("Expected: true. Actual: " + (target.containsAll(permute) && permute.containsAll(target)));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> inner = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) inner.add(nums[i]);

        backtrack(0, nums.length, inner, result);
        return result;
    }

    private static void backtrack(int first, int length, List<Integer> from, List<List<Integer>> to) {
        if (length == first) to.add(new ArrayList<>(from));

        for (int i = first; i < length; i++) {
            Collections.swap(from, first, i);
            backtrack(first + 1, length, from, to);
            Collections.swap(from, first, i);
        }
    }


    private static List<List<Integer>> createTarget() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(3);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(1);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(1);
        list4.add(2);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(2);
        list5.add(1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);
        res.add(list5);
        return res;
    }
}
