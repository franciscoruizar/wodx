package ar.franciscoruiz.apps.accounts.backend.controllers.memberships.dto;

public final class MembershipRequest {
    private String  id;
    private String  description;
    private Integer numberDaysEnabled;
    private Double  price;
    private String  companyId;
    private Boolean isActive;

    public MembershipRequest(String id, String description, Integer numberDaysEnabled, Double price, String companyId, Boolean isActive) {
        this.id                = id;
        this.description       = description;
        this.numberDaysEnabled = numberDaysEnabled;
        this.price             = price;
        this.companyId         = companyId;
        this.isActive          = isActive;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public Integer numberDaysEnabled() {
        return this.numberDaysEnabled;
    }

    public Double price() {
        return this.price;
    }

    public String companyId() {
        return this.companyId;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberDaysEnabled(Integer numberDaysEnabled) {
        this.numberDaysEnabled = numberDaysEnabled;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
