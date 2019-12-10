package lang.methodref;

@FunctionalInterface
public interface FunctionalConvertertable<T> {
    FunctionalConverter<?> transform();
}
