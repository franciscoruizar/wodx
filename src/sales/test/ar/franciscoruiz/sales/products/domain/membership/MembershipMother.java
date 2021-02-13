package ar.franciscoruiz.sales.products.domain.membership;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.companies.CompanyIdMother;

public final class MembershipMother {
    public static Membership create(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        CompanyId companyId,
        ProductIsActive isActive,
        MembershipNumberDaysEnabled numberDaysEnabled
    ) {
        return new Membership(
            id,
            title,
            description,
            price,
            isActive,
            companyId,
            numberDaysEnabled
        );
    }

    public static Membership random() {
        return create(
            ProductIdMother.random(),
            ProductTitleMother.random(),
            ProductDescriptionMother.random(),
            ProductPriceMother.random(),
            CompanyIdMother.random(),
            ProductIsActiveMother.random(),
            MembershipNumberDaysEnabledMother.random()
        );
    }
}
