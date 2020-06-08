package dynamicProgramming;


import java.util.HashMap;
import java.util.Map;

public class ClimbStairsWithDifferentSteps {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(f(44, new int[]{1, 3, 5}));
    }

    private static int f(int n, int[] ints) {
        return ff(n, ints);
    }

    private static int ff(int i, int[] ints) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        if (i == 0) {
            return 1;
        } else if (i < 0) {
            return 0;
        } else {
            int val = 0;
            for (int j = 0; j < ints.length; j++) {
                val += ff(i - ints[j], ints);
            }
            map.put(i, val);
            return val;
        }
    }

}
