package lang.wildcard;

import java.util.List;
import java.util.Objects;

public class ListPrinter {
    public static void printObjectList(List<Object> list) {
        list.forEach(System.out::println);
    }

    public static void printAnyList(List<?> list) {
        // only Objects.toString(list) used
        list.forEach(System.out::println);
    }

    public static void printNumberList(List<? extends Number> list) {
        // IN list: use ? extends
        list.forEach(System.out::println);
    }

    public static void toIntegerList(List<? extends Number> source, List<? super Integer> target) {
        // OUT target: ? super Integer
    }
}
