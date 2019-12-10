package patterns.persist.utils;

import patterns.persist.entity.Account;
import patterns.persist.entity.AccountDto;
import patterns.persist.entity.DealDto;
import patterns.persist.entity.LegalEntityDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DealTransformerTest {
    @Test
    public void transformer() {
        DealDto dealDto = new DealDto();
        dealDto.setDealId("1");
        dealDto.setDealName("dealName");
        LegalEntityDto legalEntityDto = new LegalEntityDto();
        legalEntityDto.setDealId("1");
        legalEntityDto.setId("01");
        legalEntityDto.setLegalName("legalName");
        dealDto.setLegalEntity(legalEntityDto);
        AccountDto accountDto = new AccountDto();
        accountDto.accName = "accName";
        accountDto.accEmail = "accEmail";
        legalEntityDto.setAccounts(Arrays.asList(accountDto));

        DealTransformer dealTransformer = new DealTransformer(dealDto);
        Transformer<DealDto> transformer = dealTransformer.transformer();
        List<Account> actual = transformer.apply(DealFunctions.toAccountList);
        Assert.assertTrue(actual.size() == 1);
    }
}
