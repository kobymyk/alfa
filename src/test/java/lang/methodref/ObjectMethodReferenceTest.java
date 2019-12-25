package lang.methodref;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectMethodReferenceTest {
    public ObjectSrc src = new ObjectSrc();

    @Test
    public void converter() {
        ObjectMethodReference methodReference = new ObjectMethodReference() {{
            setSrc(src);
        }};

        src.id = 1;
        ObjectTarget actual = methodReference.getSrcConverter().apply(ObjectSrcConvertUtils::toObjectTarget);
        assertEquals("1", actual.id);

        src.id = 2;
        FunctionalConverter<ObjectSrc> converter = methodReference.getAnyConverter();
        actual = converter.apply(ObjectSrcConvertUtils::toObjectTarget);
        assertEquals("2", actual.id);
    }
}
