package lang.methodref;

import org.junit.Assert;
import org.junit.Test;

public class StaticMethodReferenceTest {
    @Test
    public void getStringConverterRef() {
        StaticMethodReference staticMethodReference = new StaticMethodReference();
        StringConverter stringConverter = staticMethodReference.getStringConverterRef();
        Assert.assertEquals(stringConverter.applyByReference("[1]"), "staticFun.source=[1]");
    }
}
