package functional.collect;

import collect.ArrayListCollector;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectTest {
    @Test
    public void toUniqueList() {
        List<String> list = Arrays.asList("a", "b");
        List<String> expected = Arrays.asList("a", "b");
        List<String> actual = list.stream().collect(ArrayListCollector.toArrayList());
        assertEquals(expected, actual);
    }
}
