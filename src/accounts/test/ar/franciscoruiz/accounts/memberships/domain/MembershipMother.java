package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyIdMother;

public final class MembershipMother {
    public static Membership create(
        MembershipId id,
        MembershipDescription description,
        MembershipNumberDaysEnabled numberDaysEnabled,
        MembershipPrice price,
        CompanyId companyId,
        MembershipIsActive isActive
    ) {
        return new Membership(id, description, numberDaysEnabled, price, companyId, isActive);
    }

    public static Membership random() {
        return create(
            MembershipIdMother.random(),
            MembershipDescriptionMother.random(),
            MembershipNumberDaysEnabledMother.random(),
            MembershipPriceMother.random(),
            CompanyIdMother.random(),
            MembershipIsActiveMother.random()
        );
    }
}
