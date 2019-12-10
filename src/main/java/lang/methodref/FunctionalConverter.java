package lang.methodref;

import java.util.function.Function;

@FunctionalInterface
public interface FunctionalConverter<T> {
    <R> R apply(Function<? super T, ? extends R> f);
}
