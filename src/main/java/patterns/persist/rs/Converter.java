package patterns.persist.rs;

@FunctionalInterface
public interface Converter<S, T> {
    T convert(S var1);
}