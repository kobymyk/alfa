package functional.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class IntegerStreamTest {
    Integer[] integerArray = {1, 3, 2};
    List<Integer> integerList = getIntegerList(integerArray);

    @Test
    public void fromValues() {
        Stream<Integer> actual = IntegerStream.fromValues(1, 2, 3);
        assertEquals(3, actual.count());
    }

    @Test
    public void fromArray() {
        Stream<Integer> actual = IntegerStream.fromArray(integerArray);
        assertEquals(3, actual.count());
    }

    @Test
    public void maxOfList() {
        Integer actual = IntegerStream.maxOfList(integerList);
        assertEquals((Integer) 3, actual);
    }

    @Test
    public void filterNull() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, null));
        Stream<Integer> actual = IntegerStream.filterNull(list);
        assertEquals(2, actual.count());
    }

    @Test
    public void distinctList() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 2));
        Stream<Integer> actual = IntegerStream.distinctList(list);
        assertEquals(2, actual.count());
    }

    @Test
    public void sumOfList() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3));
        IntSummaryStatistics actual = IntegerStream.getStatistics(list);
        assertEquals(6, actual.getSum());
        assertEquals(1, actual.getMin());
        assertEquals(3, actual.getMax());
    }

    @Test
    public void limitList() {
        Stream<Integer> actual = IntegerStream.limitList(integerList, 2);
        assertEquals(2, actual.count());
    }

    @Test
    public void addToEach() {
        Stream<Integer> actual = IntegerStream.addToEach(integerList, 1);
        assertEquals((Integer) 2, actual.findFirst().get());
    }

    @Test
    public void stringList() {
        Stream<String> actual = IntegerStream.stringList(integerList);
        assertEquals("1", actual.findFirst().get());
    }

    private List<Integer> getIntegerList(Integer[] array) {
        return new ArrayList(Arrays.asList(array));
    }
}
