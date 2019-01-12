package main;

import kotlin.Pair;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIteration {
    public static <T> List<T> streamIteration(
            UnaryOperator<T> f,
            T x0,
            BiPredicate<T, T> cond,
            int nMax
    ) {
        Stream<Pair<T, T>> stream = Stream.iterate(
                new Pair<T, T>(null, x0),
                (it) -> new Pair<>(it.getSecond(), f.apply(it.getSecond()))
        ).limit(nMax).takeWhile(
                (it) -> {
                    System.out.println((it.getFirst() == null) || !cond.test(it.getFirst(), it.getSecond()));
                    return (it.getFirst() == null) || !cond.test(it.getFirst(), it.getSecond());
                }
        );
        return stream.map(Pair::getSecond).collect(Collectors.toList());
    }

    public static List<Integer> fibo(int nMax){
        return Stream.iterate(
                new Pair<>(0, 1),
                (it) -> new Pair<>(it.getSecond(), it.getFirst() + it.getSecond())
        ).limit(nMax).map(
                Pair::getFirst
        ).collect(Collectors.toList());
    }
}
