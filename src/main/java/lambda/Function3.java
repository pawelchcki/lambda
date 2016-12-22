package lambda;

@FunctionalInterface
public interface Function3<T, U, O, R> {
    R apply(T var1, U var2, O var3);

    default BiFunction<T, U, R> curry(O var3) {
        return (T var1, U var2) -> apply(var1, var2, var3);
    }

    default Function<T, R> curry(U var2, O var3) {
        return (T var1) -> apply(var1, var2, var3);
    }

    default Supplier<R> curry(T var1, U var2, O var3) {
        return () -> apply(var1, var2, var3);
    }
}
