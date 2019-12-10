package patterns.persist.entity;

import patterns.persist.rs.Converter;
import patterns.persist.service.types.DealChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DealChangeMapper implements Converter<DealDto, List<DealChange>> {
    @Override
    public List<DealChange> convert(DealDto source) {
        List<DealChange> result = new ArrayList<>();
        LegalEntityDto sourceLegalEntity = source.getLegalEntity();
        if (Objects.nonNull(sourceLegalEntity)) {
            Optional<LegalEntity> optionalLegalEntity = DealMapper.toLegalEntity(source);
            if (optionalLegalEntity.isPresent()) {
                LegalEntity legalEntity = optionalLegalEntity.get();
                DealChange dealChange = new DealChange();
                // legalEntity/name
                dealChange.setValue(legalEntity.getName());
                dealChange.setXpath("/legalEntity/name");
                dealChange.setType("String");
                result.add(dealChange);
                // legalEntity/taxNumberList
                List<Account> accountList = DealMapper.toAccountList(sourceLegalEntity.getAccounts());
                if (!accountList.isEmpty()) {
                    dealChange = new DealChange();
                    dealChange.setValue(accountList.toString());
                    dealChange.setXpath("/legalEntity/accountList");
                    dealChange.setType("Account[]");
                    result.add(dealChange);
                }
            }
        }

        return result;
    }
}
