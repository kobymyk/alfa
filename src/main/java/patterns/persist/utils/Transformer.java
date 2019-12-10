package patterns.persist.utils;

import java.util.function.Function;

@FunctionalInterface
interface Transformer<T> {
    <R> R apply(Function<? super T, ? extends R> f);
}