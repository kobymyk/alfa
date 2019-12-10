package libs.jaxon;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountMapperTest {
    private static Account account = new Account();
    @Before
    public void init() {
        account.id = "1";
        account.name = "name";
        account.email = "email";
        account.internal = "x";
    }

    @Test
    public void toRequest() throws JsonProcessingException {
        AccountMapper mapper = new AccountMapper();
        String actual = mapper.toRequest(account);
        Assert.assertEquals("{\"id\":\"1\",\"name\":\"name\",\"email\":\"email\"}", actual);
    }

    @Test
    public void toUpdate() throws JsonProcessingException {
        AccountMapper mapper = new AccountMapper();
        String actual = mapper.toUpdate(account);
        Assert.assertEquals("{\"name\":\"name\",\"email\":\"email\"}", actual);
    }

}
