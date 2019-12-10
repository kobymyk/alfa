package functional.stream;

import java.util.*;
import java.util.stream.Stream;

public class IntegerStream {
    public static Stream<Integer> fromValues(Integer... values) {
        return Stream.of(values);
    }

    public static Stream<Integer> fromArray(Integer[] integerArray) {
        return Arrays.stream(integerArray);
    }

    public static Integer maxOfList(List<Integer> integerList) {
        Optional<Integer> result;
        result = integerList.stream().max((x, y) -> x.compareTo(y)); //Integer::compareTo

        return result.isPresent() ? result.get() : null;
    }

    public static Stream<Integer> filterNull(List<Integer> integerList) {
        return integerList.stream().filter(Objects::nonNull); //i -> i != null
    }

    public static Stream<Integer> distinctList(List<Integer> integerList) {
        return integerList.stream().distinct();
    }

    public static IntSummaryStatistics getStatistics(List<Integer> integerList) {
        return integerList.stream().mapToInt(x -> x).summaryStatistics();
    }

    public static Stream<Integer> limitList(List<Integer> integerList, long maxSize) {
        return integerList.stream().limit(maxSize);
    }

    public static Stream<Integer> addToEach(List<Integer> integerList, int value) {
        return integerList.stream().map(i -> i + value);
    }

    public static Stream<String> stringList(List<Integer> integerList) {
        return integerList.stream().map(String::valueOf); //i -> i.toString()
    }
}
