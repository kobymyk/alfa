package lang.wildcard;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPrinterTest {
    List<Number> numberList = Arrays.asList(1, 2, 3);
    List<String> stringList = Arrays.asList("1", "2", "3");
    List<Object> objects = new ArrayList<>(2);
    Object object = new Object();

    @Before
    public void init() {
        objects.add(object);
        objects.add(new Object());

    }
    @Test
    public void printObjectList() {
        //ListPrinter.printObjectList(stringList);
        ListPrinter.printObjectList(objects);
    }
    //
    @Test
    public void printAnyList() {
        ListPrinter.printAnyList(stringList);
        ListPrinter.printAnyList(objects);
    }
    //
    @Test
    public void printNumberList() {
        ListPrinter.printNumberList(numberList);
    }
}
