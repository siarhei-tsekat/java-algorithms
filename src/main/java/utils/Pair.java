package utils;

public class Pair<T, T1> {
    private final T t;
    private final T1 t1;

    public Pair(T t, T1 t1) {
        this.t = t;
        this.t1 = t1;
    }

    public T getKey() {
        return t;
    }

    public T1 getValue() {
        return t1;
    }
}
