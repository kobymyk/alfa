package libs.jaxon;

import com.fasterxml.jackson.annotation.JsonView;
import libs.jaxon.DealViews.*;

public class Account {
    @JsonView({RequestDeal.class})
    public String id;
    @JsonView({UpdateDeal.class, RequestDeal.class})
    public String name;
    public String email;
    @JsonView({UpdateDeal.Account.class})
    public String internal;
}
