package patterns.persist.entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DealMapper {
    public static Optional<LegalEntity> toLegalEntity(DealDto source) {
        LegalEntity result = null;
        LegalEntityDto value = source.getLegalEntity();
        if (Objects.nonNull(value)) {
            result = new LegalEntity();
            result.setName(value.getLegalName());
        }

        return Optional.of(result);
    }

    public static List<Account> toAccountList(List<AccountDto> source) {
        List<Account> result = source.stream()
                .map(DealMapper::toAccount)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return result;
    }

    public static Optional<Account> toAccount(AccountDto source) {
        Account result = null;
        if (Objects.nonNull(source)) {
            result = new Account();
            result.name = source.accName;
            result.email = source.accEmail;
        }
        return Optional.of(result);
    }
}
