package patterns.persist.utils;

import patterns.persist.entity.Account;
import patterns.persist.entity.DealDto;
import patterns.persist.entity.DealMapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DealFunctions {
    public static final Function<DealDto, List<Account>> toAccountList = d -> {
        return d.getLegalEntity().getAccounts().stream()
                .map(DealMapper::toAccount)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    };
}
