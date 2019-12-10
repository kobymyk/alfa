package patterns.persist.entity;

import java.util.List;

public class LegalEntity {
    String id;
    String dealId;
    String name;
    List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
