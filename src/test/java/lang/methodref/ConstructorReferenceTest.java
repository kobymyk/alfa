package lang.methodref;

import org.junit.Assert;
import org.junit.Test;

public class ConstructorReferenceTest {
    ObjectSrc src = new ObjectSrc();
    @Test
    public void converter() {
        Messageable reference = ConstructorReference.getReference();

        Message actual = reference.getMessage("A");
        Assert.assertEquals("A", actual.msg);
    }
}
