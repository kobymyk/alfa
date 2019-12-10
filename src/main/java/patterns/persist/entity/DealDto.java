package patterns.persist.entity;

public class DealDto {
    String dealId;
    String dealName;
    LegalEntityDto legalEntity;

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public LegalEntityDto getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntityDto legalEntity) {
        this.legalEntity = legalEntity;
    }
}
