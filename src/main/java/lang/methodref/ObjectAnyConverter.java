package lang.methodref;

import java.util.function.Function;

public class ObjectAnyConverter<T> implements FunctionalConvertertable {
    T src;

    public ObjectAnyConverter() {
    }

    public ObjectAnyConverter(T src) {
        this.src = src;
    }

    @Override
    public FunctionalConverter<T> transform() {
        return this::callFunction;
    }

    private <R> R callFunction(Function<? super T, ? extends R> f) {
        return f.apply(src);
    }
}
