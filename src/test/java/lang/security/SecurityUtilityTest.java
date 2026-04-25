package lang.security;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecurityUtilityTest {

    @Test
    public void getHash() {
        String actual = SecurityUtility.getHash("hello");
        assertEquals("XUFAKrxLKna5cZ2REBfFkg==", actual);
    }
}
