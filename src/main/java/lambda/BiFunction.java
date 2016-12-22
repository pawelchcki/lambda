package lambda;

public interface BiFunction<T,U,R> extends java.util.function.BiFunction<T,U,R> {
    default Function<T,R> curry(final U arg1){
        return (T arg0) -> apply(arg0, arg1);
    }

    default Supplier<R> curry(final T arg0, final U arg1){
        return () -> apply(arg0, arg1);
    }
}
