package backtracking;

import java.util.ArrayList;
import java.util.List;


class R_unner {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

}

public class Combinations {
    public List<List<Integer>> combine(int end, int amount) {
        List<List<Integer>> res = new ArrayList<>();
        func(1, end, amount, res, new ArrayList<>());
        return res;
    }

    public void func(int start, int end, int amount, List<List<Integer>> res, List<Integer> tmp) {
        if(amount == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i <= end - amount + 1; i++) {
            System.out.println(tab(start)+">>for start  = " + start + " index of cycle i = "+i);
            tmp.add(i);
            System.out.println(tab(start)+"added i = " + i + " tmp = " + tmp);
            func(i + 1, end, amount-1, res, tmp);
            tmp.remove(tmp.size() - 1);
            System.out.println(tab(start)+"removed i = " + i + " tmp = " + tmp);
        }
    }

    private String tab(int start) {
        String str = "\t";
        for (int i = 1; i < start; i++) {
            str+="\t";
        }
        return str;
    }
}
