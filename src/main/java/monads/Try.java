package monads;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Try<T> {

    private final boolean success;

    public Try(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isFailure() {
        return this.success == false;
    }

    public abstract Throwable getThrownMessage();

    public abstract T get();

    public abstract <U> Try<U> map(Function<? super T, ? extends U> function);

    public abstract <U> Try<U> flatMap(Function<? super T, ? extends Try<U>> function);

    public abstract void foreach(Consumer<T> consumer);

    public static <T> Try<T> failure(Throwable t) {
        Objects.requireNonNull(t);
        return new Failure<>(t);
    }

    public static <V> Try.Success<V> success(V value) {
        Objects.requireNonNull(value);
        return new Success<>(value);
    }

    public static <T> Try<T> of(Supplier<T> function) {
        Objects.requireNonNull(function);
        try {
            return Try.success(function.get());
        } catch (Throwable e) {
            return Try.failure(e);
        }
    }

    static class Failure<T> extends Try<T> {
        private final RuntimeException runtimeException;

        public Failure(Throwable t) {
            super(false);
            this.runtimeException = new RuntimeException(t);
        }

        @Override
        public Throwable getThrownMessage() {
            return this.runtimeException;
        }

        @Override
        public T get() {
            throw this.runtimeException;
        }

        @Override
        public <U> Try<U> map(Function<? super T, ? extends U> function) {
            Objects.requireNonNull(function);
            return Try.failure(this.runtimeException);
        }

        @Override
        public <U> Try<U> flatMap(Function<? super T, ? extends Try<U>> function) {
            Objects.requireNonNull(function);
            return Try.failure(this.runtimeException);
        }

        @Override
        public void foreach(Consumer<T> consumer) {
            Objects.requireNonNull(consumer);
            Try.failure(this.runtimeException);
        }
    }

    static class Success<T> extends Try<T> {

        private final T value;

        public Success(T value) {
            super(true);
            this.value = value;
        }

        @Override
        public Throwable getThrownMessage() {
            throw new IllegalStateException("Success never has an exception");
        }

        @Override
        public T get() {
            return this.value;
        }

        @Override
        public <U> Try<U> map(Function<? super T, ? extends U> function) {
            Objects.requireNonNull(function);
            try {
                return Try.success(function.apply(this.value));
            } catch (Throwable t) {
                return Try.failure(t);
            }
        }

        @Override
        public <U> Try<U> flatMap(Function<? super T, ? extends Try<U>> function) {
            Objects.requireNonNull(function);
            try {
                return function.apply(this.value);
            } catch (Throwable t) {
                return Try.failure(t);
            }
        }

        @Override
        public void foreach(Consumer<T> consumer) {
            Objects.requireNonNull(consumer);
            try {
                consumer.accept(this.value);
            } catch (Throwable t) {
                Try.failure(t);
            }
        }
    }
}

