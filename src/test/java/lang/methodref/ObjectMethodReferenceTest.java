package lang.methodref;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class ObjectMethodReferenceTest {
    ObjectSrc src = new ObjectSrc();
    @Test
    public void converter() {
        ObjectMethodReference methodReference = new ObjectMethodReference();
        src.id = 1;
        methodReference.src = src;

        ObjectTarget actual  = methodReference.getConverter().apply(ObjectSrcConvertUtils::toObjectTarget);

        Assert.assertEquals("1", actual.id);
    }
}
