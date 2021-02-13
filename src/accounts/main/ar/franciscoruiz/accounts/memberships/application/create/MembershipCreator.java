package ar.franciscoruiz.accounts.memberships.application.create;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.accounts.memberships.domain.*;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipCreator {
    private final MembershipDomainCreator creator;

    public MembershipCreator(MembershipDomainCreator creator) {
        this.creator = creator;
    }

    public void create(
        MembershipId id,
        MembershipDescription description,
        MembershipNumberDaysEnabled numberDaysEnabled,
        MembershipPrice price,
        CompanyId companyId,
        MembershipIsActive isActive
    ) {
        this.creator.create(id, description, numberDaysEnabled, price, companyId, isActive);
    }
}
