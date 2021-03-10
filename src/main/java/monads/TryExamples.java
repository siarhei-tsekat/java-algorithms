package monads;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static monads.ToxicFunction.Try;

public class TryExamples {

    // first example
    public void readWithException(Stream<File> files) {
        files.map((f) -> {
            try {
                return read(f);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    // second example
    public void readWithFunctionalInterface(Stream<File> files) {
        files.map(Try(this::read))
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    // third example
    public void readWithTry(Stream<File> files) {
        Try<String> result = Try.of(() -> Try(this::read).apply(null));

        if (result.isSuccess()) {
            System.out.println(result.get());
        } else {
            System.out.println(result.getThrownMessage().getMessage());
        }

        Try.of(() -> Try(this::read).apply(null)).foreach(System.out::println);
    }

    public String read(File input) throws IOException { /* mock*/return ""; }
}

@FunctionalInterface
interface ToxicFunction<IN, OUT> {
    OUT apply(IN param) throws Exception;

    static <IN, OUT> Function<IN, OUT> Try(ToxicFunction<IN, OUT> function) {
        return params -> {
            try {
                return function.apply(params);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}


