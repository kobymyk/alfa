package patterns.transformer;

import java.util.function.Function;

@FunctionalInterface
interface Transformer<T> {
    <R> R by(Function<? super T, ? extends R> f);
}
