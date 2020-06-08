package fox.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Condition<T> {
    public boolean apply(T t);
}

public class App2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 15, 32));

        List<Integer> allNumbersBigger5 = filterNumber((i) -> i > 5, list);

        List<Integer> allNumbersLess10 = filterNumber((el) -> el < 10, list);
    }

    private static List<Integer> filterNumber(Condition<Integer> condition, List<Integer> list) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (condition.apply(list.get(i))) res.add(list.get(i));
        }
        return res;
    }
}
