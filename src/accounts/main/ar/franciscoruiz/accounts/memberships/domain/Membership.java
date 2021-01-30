package ar.franciscoruiz.accounts.memberships.domain;

public final class Membership {
    private final String  id;
    private final String  description;
    private final Integer numberDaysEnabled;
    private final Double  price;
    private final String  companyId;
    private final Boolean isActive;

    public Membership(String id, String description, Integer numberDaysEnabled, Double price, String companyId, Boolean isActive) {
        this.id                = id;
        this.description       = description;
        this.numberDaysEnabled = numberDaysEnabled;
        this.price             = price;
        this.companyId         = companyId;
        this.isActive          = isActive;
    }

    public Membership() {
        this.id                = null;
        this.description       = null;
        this.numberDaysEnabled = null;
        this.price             = null;
        this.companyId         = null;
        this.isActive          = null;
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
}
