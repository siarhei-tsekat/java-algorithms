package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(f(44));
    }

    private static int f(int n) {
        return ff(n);
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    private static int ff(int i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        if (i == 0) {
            return 1;
        } else if (i < 0) {
            return 0;
        } else {
            int val = ff(i - 1) + ff(i - 2);
            map.put(i, val);
            return val;
        }
    }
}
