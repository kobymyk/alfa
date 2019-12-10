package patterns.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordTest {
    @Test
    public void builder() {
        Record.Builder builder = new Record.Builder(12)
                .setSource("SRC_1");
        builder.setPath("path_1").setValue("value_1");

        Record actual = builder.get();
        assertEquals(actual.getObjectId(), 12);
        assertEquals(actual.getValue(), "value_1");

        builder.setValue("value_2");
        actual = builder.get();
        assertEquals(actual.getObjectId(), 12);
        assertEquals(actual.getValue(), "value_2");
        //
        builder.setType("type_1");
        actual = builder.get();
        assertEquals(actual.getValue(), "<type=type_1>value_2");
    }
}
