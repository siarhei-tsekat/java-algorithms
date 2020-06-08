package fox.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 15, 32));

        List<Integer> allNumbersBigger5 = getAllNumbersBigger5(list);

        List<Integer> allNumbersLess10 = getAllNumbersLess10(list);
    }

    private static List<Integer> getAllNumbersBigger5(List<Integer> list) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 5) res.add(list.get(i));
        }
        return res;
    }

    private static List<Integer> getAllNumbersLess10(List<Integer> list) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 10) res.add(list.get(i));
        }
        return res;
    }
}
