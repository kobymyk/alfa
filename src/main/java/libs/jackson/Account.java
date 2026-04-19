package libs.jackson;

import com.fasterxml.jackson.annotation.JsonView;
import libs.jackson.DealViews.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @JsonView({RequestDeal.class})
    public int id;
    @JsonView({UpdateDeal.class, RequestDeal.class})
    public String name;
    public String email;
    //todo: test
    @JsonView({UpdateDeal.Account.class})
    public String internal;
}
