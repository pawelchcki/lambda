package lambda;

public interface Function<T,R> extends java.util.function.Function<T,R> {
    default Supplier<R> curry(T var1) {
        return () -> apply(var1);
    }

}
