package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.Objects;

public final class Membership {
    private final MembershipId                id;
    private final MembershipDescription       description;
    private final MembershipNumberDaysEnabled numberDaysEnabled;
    private final MembershipPrice             price;
    private final CompanyId                   companyId;
    private final MembershipIsActive          isActive;

    public Membership(
        MembershipId id,
        MembershipDescription description,
        MembershipNumberDaysEnabled numberDaysEnabled,
        MembershipPrice price,
        CompanyId companyId,
        MembershipIsActive isActive
    ) {
        this.id                = id;
        this.description       = description;
        this.numberDaysEnabled = numberDaysEnabled;
        this.price             = price;
        this.companyId         = companyId;
        this.isActive          = isActive;
    }

    private Membership() {
        this.id                = null;
        this.description       = null;
        this.numberDaysEnabled = null;
        this.price             = null;
        this.companyId         = null;
        this.isActive          = null;
    }

    public MembershipId id() {
        return id;
    }

    public MembershipDescription description() {
        return description;
    }

    public MembershipNumberDaysEnabled numberDaysEnabled() {
        return numberDaysEnabled;
    }

    public MembershipPrice price() {
        return price;
    }

    public CompanyId companyId() {
        return companyId;
    }

    public MembershipIsActive isActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(numberDaysEnabled, that.numberDaysEnabled) && Objects.equals(price, that.price) && Objects.equals(companyId, that.companyId) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, numberDaysEnabled, price, companyId, isActive);
    }
}
