package ar.franciscoruiz.accounts.memberships.application.create;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.memberships.domain.*;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipCreator {
    private final MembershipRepository repository;

    public MembershipCreator(MembershipRepository repository) {
        this.repository = repository;
    }

    public void create(
        MembershipId id,
        MembershipDescription description,
        MembershipNumberDaysEnabled numberDaysEnabled,
        MembershipPrice price,
        CompanyId companyId,
        MembershipIsActive isActive
    ) {
        Membership membership = new Membership(id.value(), description.value(), numberDaysEnabled.value(), price.value(), companyId.value(), isActive.value());

        this.repository.save(membership);
    }
}
