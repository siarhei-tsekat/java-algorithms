package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println("210 => " + new ___Solution().largestNumber(new int[]{10, 2}));
        System.out.println("9534330 => " + new ___Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println("330 => " + new ___Solution().largestNumber(new int[]{3, 30}));
        System.out.println("343 => " + new ___Solution().largestNumber(new int[]{3, 34}));
        System.out.println("12121 => " + new ___Solution().largestNumber(new int[]{121, 12}));
        System.out.println("0 => " + new ___Solution().largestNumber(new int[]{0, 0}));
    }
}

class ___Solution {
    public String largestNumber(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((f, s) -> comparator(f, s));

        for (int num : nums) queue.add(num);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) sb.append(queue.poll());
        if (sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }

    private int comparator(Integer f, Integer s) {
        String fs = Integer.toString(f);
        String ss = Integer.toString(s);
        String s1 = fs + ss;
        String s2 = ss + fs;

        return s2.compareTo(s1);
    }
}
