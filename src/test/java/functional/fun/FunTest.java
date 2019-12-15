package functional.fun;

import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FunTest {
    @Test
    public void shortToByte() {
        short[] array = {(short) 1, (short) 2, (short) 3};

        ShortToByteFunction fun = FunctionUtil.toByte;
        byte[] actual = FunctionShortToByte.transformArray(array, fun);

        byte[] expected = {(byte) 2, (byte) 4, (byte) 6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void replaceUnary() {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("A", "B", "C");

        ListFun.replace(list);
        assertEquals(expected, list);
    }

    @Test
    public void forEach() {
        List<Record> list = new ArrayList<>(2);
        Record record = new Record();
        record.id = "id[1]";
        record.name = "name[1]";
        list.add(record);
        // modified
        ListFun.listForEach(list);
        assertNotEquals("id[1]", list.get(0).id);
        // modified as well
        record.id = "id[1]";
        ListFun.streamForEach(list);
        assertNotEquals("id[1]", list.get(0).id);
    }

    @Test
    public void replaceBinary() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        BiFunction<String, Integer, Integer> fun = (s, i) -> "a".equals(s) ? i - 1 : i;
        map.replaceAll(fun);
        assertEquals(map.get("a"), (Integer)0);
    }

    @Test
    public void supplyFibonacci() {
        SupplierFibonacci supplier = new SupplierFibonacci();
        List<Integer> list = supplier.supply(8);
        List<Integer> expected = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21);
        assertEquals(expected, list);
    }

    @Test
    public void consumeOut() {
        List<String> list = Arrays.asList("a", "b", "c");
        Consumer<String> consumer = System.out::println;
        list.forEach(consumer); //list.stream().forEach();
    }

    @Test
    public void predicate() {
        List<Integer> list = Arrays.asList(1, -1, 0);
        List<Integer> expected = Arrays.asList(1, 0);
        Predicate<Integer> positiveFilter = x -> x >= 0;
        List<Integer> actual = list.stream().filter(positiveFilter).collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    @Test
    public void reduce() {
        List<String> list = Arrays.asList("a", "b", "c");
        BinaryOperator<String> accumulator = (s1, s2) -> s1 + s2;
        String actual = list.stream().reduce("", accumulator);
        assertEquals("abc", actual);
    }

    @Test
    public void threadRun() {
        Runnable runnable = () -> System.out.println("Another Thread");
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
