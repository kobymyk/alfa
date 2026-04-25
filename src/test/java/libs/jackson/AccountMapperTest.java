package libs.jackson;

import org.junit.Before;
import org.junit.Test;

import static libs.jackson.DataViews.DEBUG_CLASS;
import static libs.jackson.DataViews.INFO_CLASS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountMapperTest {
    private static final String TEST_FOLDER = "src/test/resources/";
    private Account account;
    private final AccountMapper mapper = new AccountMapper();

    @Before
    public void init() {
        account = createAccount();
    }

    private Account createAccount() {
        return Account.builder()
                .id(1)
                .name("name")
                .email("email")
                .password("password")
                .build();
    }

    @Test
    public void toStringByView() {
        String actual = mapper.toStringByView(account, INFO_CLASS);
        assertEquals("{\"name\":\"name\",\"email\":\"email\"}", actual);

        actual = mapper.toStringByView(account, DataViews.Warn.class);
        assertEquals("{\"id\":1,\"name\":\"name\",\"email\":\"email\"}", actual);

        actual = mapper.toStringByView(account, DEBUG_CLASS);
        assertEquals("{\"id\":1,\"name\":\"name\",\"email\":\"email\",\"password\":\"password\"}", actual);
    }

    @Test
    public void toStringForDebug() {
        String actual = mapper.toStringForWarn(account);
        assertEquals("{\"id\":1,\"name\":\"name\",\"email\":\"email\",\"password\":\"password\"}", actual);
    }

    @Test
    public void readObject() {
        Account actual = AccountMapper.readObject(TEST_FOLDER + "Account.json", Account.class);
        assertTrue(actual.id == 1 && "name-1".equals(actual.name));
    }

}
