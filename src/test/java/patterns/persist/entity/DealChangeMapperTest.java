package patterns.persist.entity;

import patterns.persist.service.types.DealChange;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DealChangeMapperTest {
    @Test
    public void convert() {
       DealDto dealDto = new DealDto();
       dealDto.setDealId("1");
       dealDto.setDealName("dealName");
       LegalEntityDto legalEntityDto = new LegalEntityDto();
       legalEntityDto.setDealId("1");
       legalEntityDto.setId("01");
       legalEntityDto.setLegalName("legalName");
       dealDto.setLegalEntity(legalEntityDto);

       DealChangeMapper dealChangeMapper = new DealChangeMapper();
       List<DealChange> actual = dealChangeMapper.convert(dealDto);
       Assert.assertNotNull(actual);
    }
}
