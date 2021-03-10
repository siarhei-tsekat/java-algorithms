package array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new S().find(new int[]{10, 2, 6, 7, 1, 9, 12, 5, 7, 10, 3})));
    }
}

class S {

    public int[] find(int[] all) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[all.length];

        for (int i = all.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && all[i] >= st.peek()) st.pop();
            res[i] = st.isEmpty() ? 0 : st.peek();
            st.push(all[i]);
        }

        return res;
    }
}
