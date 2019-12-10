package patterns.persist.service;

public interface DealItem<T> {
    void update(T item);
}
