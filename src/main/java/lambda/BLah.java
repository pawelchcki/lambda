package lambda;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class BLah {

    public static <T, R> java.util.function.Function<T, R> of(java.util.function.Function<T, R> fn) {
        return fn;
    }

    public static <T1, T2, R> java.util.function.BiFunction<T1, T2, R> of(java.util.function.BiFunction<T1, T2, R> fn) {
        return fn;
    }

    public static void main(String... args) {
        AtomicInteger cnt = new AtomicInteger();
        Callable<Integer> fn = () -> {
            System.err.println("start " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.err.println("end " + Thread.currentThread().getName());
            return cnt.incrementAndGet();
        };

        Integer integer = Observable.fromCallable(fn).subscribeOn(Schedulers.computation()). repeat().mergeWith(
                Observable.fromCallable(fn).subscribeOn(Schedulers.computation()).repeat()
        ).subscribeOn(Schedulers.computation()).take(1000).doOnNext(System.err::println).blockingLast();


        System.err.println(integer);

//        val s = Stream.of("a", "b", "c");
//        Function3<String, String, String, String> fn = (var1, var2, var3) ->
//                var1 + "." + var2 + "." + var3;
//        val a = fn.curry("3");
//        System.err.println(a.apply("1", "2"));
//
//        Function3<CharSequence, String, String, String> join = String::join;
//
//        join.apply
//
//        Stream.of(new Zaaz("a", "b"), new Zaaz("ą", "ę"))
//                .map(x -> x.withU("shit"))
//                .map(curry(Zaaz::withO, "shoot"))
//                .map(z -> z.getO() + " - " + z.getU())
//                .peek(System.err::println)
//                .collect(Collectors.toList());
//
//        s.map(curry(fn, "h", "a"))
//                .forEach(System.err::println);
//
//        System.err.println(a.curry("2").apply("1"));
//        System.err.println(a.curry("1", "2").get());
    }

    public static class StopWatch {

        private long startTime = 0;
        private long stopTime = 0;
        private boolean running = false;


        public void start() {
            this.startTime = System.currentTimeMillis();
            this.running = true;
        }


        public void stop() {
            this.stopTime = System.currentTimeMillis();
            this.running = false;
        }


        //elaspsed time in milliseconds
        public long getElapsedTime() {
            long elapsed;
            if (running) {
                elapsed = (System.currentTimeMillis() - startTime);
            } else {
                elapsed = (stopTime - startTime);
            }
            return elapsed;
        }


        //elaspsed time in seconds
        public long getElapsedTimeSecs() {
            long elapsed;
            if (running) {
                elapsed = ((System.currentTimeMillis() - startTime) / 1000);
            } else {
                elapsed = ((stopTime - startTime) / 1000);
            }
            return elapsed;
        }
    }
}
