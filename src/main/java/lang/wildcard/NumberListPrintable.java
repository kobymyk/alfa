package lang.wildcard;

import java.util.List;

public interface NumberListPrintable<T> {
    void printNumberList(List<? extends T> list);
}
