package fox;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public <T> List<T> filter(List<T> by, Predicate<T> condition) {
        return by.stream().filter(condition).collect(Collectors.toList());
    }

    public <T extends String, R extends String> R transfrom(T from) {
        return (R)from;
    }


}

class Runner {
    public static void main(String[] args) {
        Filter filter = new Filter();
        List<String> list = filter.filter(Arrays.asList("1", "s2"), (s) -> s.startsWith("s"));
        System.out.println(list);

    }
}
