package lambda;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {
    R apply(T1 arg1, T2 arg2, T3 arg3, T4 arg4);

    default Function3<T1, T2, T3, R> curry(T4 arg4) {
        return (T1 arg1, T2 arg2, T3 arg3) -> apply(arg1, arg2, arg3, arg4);
    }

    default BiFunction<T1, T2, R> curry(T3 arg3, T4 arg4) {
        return (T1 arg1, T2 arg2) -> apply(arg1, arg2, arg3, arg4);
    }

    default Function<T1, R> curry(T2 arg2, T3 arg3, T4 arg4) {
        return (T1 arg1) -> apply(arg1, arg2, arg3, arg4);
    }

    default Supplier<R> curry(T1 arg1, T2 arg2, T3 arg3, T4 arg4) {
        return () -> apply(arg1, arg2, arg3, arg4);
    }
}
