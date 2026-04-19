package libs.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountMapperTest {
    private static final String TEST_FOLDER = "src/test/resources/";
    private Account account;

    @Before
    public void init() {
        account = Account.builder()
                .id(1)
                .name("name")
                .email("email")
                .build();
    }

    @Test
    public void toRequest() throws JsonProcessingException {
        AccountMapper mapper = new AccountMapper();
        String actual = mapper.toRequest(account);
        assertEquals("{\"id\":1,\"name\":\"name\",\"email\":\"email\"}", actual);
    }

    @Test
    public void toUpdate() throws JsonProcessingException {
        AccountMapper mapper = new AccountMapper();
        String actual = mapper.toUpdate(account);
        assertEquals("{\"name\":\"name\",\"email\":\"email\"}", actual);
    }

    @Test
    public void readObject() {
        Account actual = AccountMapper.readObject(TEST_FOLDER + "Account.json", Account.class);
        assertTrue(actual.id == 1 && "name-1".equals(actual.name));
    }

}
