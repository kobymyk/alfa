package lang.methodref;

import java.util.function.Function;

public class ObjectSrcConverter implements FunctionalConvertertable {
    ObjectSrc src;

    public ObjectSrcConverter() {
    }

    public ObjectSrcConverter(ObjectSrc src) {
        this.src = src;
    }

    @Override
    public FunctionalConverter<ObjectSrc> transform() {
        return this::callFunction;
    }

    private <R> R callFunction(Function<? super ObjectSrc, ? extends R> f) {
        return f.apply(src);
    }
}
