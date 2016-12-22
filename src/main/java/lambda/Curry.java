package lambda;


import java.util.Arrays;
import java.util.List;

public class Curry {
    public static <T, U, R> Function<T, R> curry(BiFunction<T, U, R> fn, U val) {
        return (x) -> fn.apply(x, val);
    }

    public static <T, U, O, R> BiFunction<T, U, R> curry(Function3<T, U, O, R> fn, O arg2) {
        return (arg0, arg1) -> fn.apply(arg0, arg1, arg2);
    }


    public static <T, U, O, R> BiFunction<T, U, R> curryAnon(Function3<T, U, O, R> fn, O arg2) {
        return new BiFunction<T, U, R>() {
            @Override
            public R apply(T arg0, U arg1) {
                return fn.apply(arg0, arg1, arg2);
            }
        };
    }

    public static <T, R> Supplier<R> curry(java.util.function.Function<T, R> fn, T arg0) {
        return () -> fn.apply(arg0);
    }


    public static <T, R> Supplier<R> curryAnon(java.util.function.Function<T, R> fn, T arg0) {
        return new Supplier<R>() {
            @Override
            public R get() {
                return fn.apply(arg0);
            }
        };
    }

    public static <T1, T2, T3, R> Function<T1, R> curry(Function3<T1, T2, T3, R> fn, T2 arg1, T3 arg2) {
        return (arg0) -> fn.apply(arg0, arg1, arg2);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, R> Function3<T1, T2, T2, R> of(BiFunction<T1, T2[], R> fn) {
        return (arg1, arg2, arg3) -> {
            final List<T2> args = Arrays.asList(arg2, arg3);
            return fn.apply(arg1, (T2[]) args.toArray());
        };
    }

//    public static Function4<CharSequence, String, String, String, String> join = String::join;
//    public static Function3<CharSequence, String, String, String> join = String::join;


//    public static <T1, T2, R> Function<T1, R> curry(BiFunction<T1,T2[],R> fn, T2[] arg1){
//        return (arg0) -> fn.apply(arg0, arg1);
//    }

//    public static <T1, T2, T3, R> BiFunction<T2, T3, R> leftCurry(Function3<T1, T2, T3,R> fn, T1 arg1){
//        return (arg2, arg3) -> fn.apply(arg1, arg2, arg3);
//    }
}
