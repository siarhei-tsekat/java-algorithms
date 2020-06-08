package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
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

    public static void main(String[] args) {
        List<List<Integer>> target = createTarget();
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println("Expected: true. Actual: " + (target.containsAll(permute) && permute.containsAll(target)));
    }

    public static List<List<Integer>> permute(int[] nums) {
        return null;
    }
}
