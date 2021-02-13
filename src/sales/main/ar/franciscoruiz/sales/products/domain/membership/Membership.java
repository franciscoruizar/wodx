package ar.franciscoruiz.sales.products.domain.membership;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.Objects;

public final class Membership extends Product {
    private final MembershipNumberDaysEnabled numberDaysEnabled;

    public Membership(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        ProductIsActive isActive,
        CompanyId companyId,
        MembershipNumberDaysEnabled numberDaysEnabled
    ) {
        super(id, title, description, price, isActive, companyId);
        this.numberDaysEnabled = numberDaysEnabled;
    }

    private Membership() {
        this.numberDaysEnabled = null;
    }

    public MembershipNumberDaysEnabled numberDaysEnabled() {
        return numberDaysEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Objects.equals(numberDaysEnabled, that.numberDaysEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberDaysEnabled);
    }
}
