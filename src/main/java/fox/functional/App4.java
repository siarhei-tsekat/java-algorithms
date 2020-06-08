package fox.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App4 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(modify((el) -> el * 5, list));
        System.out.println(filter((el) -> el > 2, list));
        action((el) -> System.out.println(el), list);

        HashMap<Integer, Integer> map = new HashMap<>();

        filterMap((key, value) -> key > 0 || value == 6, map);
    }

    private static void filterMap(BiPredicate<Integer, Integer> condition, HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            Integer value = entry.getValue();
            Integer key = entry.getKey();

            if (condition.test(key, value)) {
                System.out.println(key);
            }
        }
    }

    private static List<Integer> modify(Function<Integer, Integer> function, List<Integer> list) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    private static List<Integer> filter(Predicate<Integer> condition, List<Integer> list) {
        return list.stream().filter(condition).collect(Collectors.toList());
    }

    private static void action(Consumer<Integer> action, List<Integer> list) {
        list.forEach(action);
    }
}

