package libs.jackson;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class XmlMapperTest {
    //todo: move to const
    private static final String TEST_FOLDER = "src/test/resources/";

    @Test
    public void readValue() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Account actual = xmlMapper.readValue(new File(TEST_FOLDER + "Account.xml"), Account.class);
        assertTrue(actual.getId() == 1
                && "name-1".equals(actual.getName()));
    }
}
