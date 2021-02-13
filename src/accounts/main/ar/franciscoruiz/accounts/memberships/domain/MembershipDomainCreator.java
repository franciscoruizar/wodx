package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipDomainCreator {
    private final MembershipRepository repository;

    public MembershipDomainCreator(MembershipRepository repository) {
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
        Membership membership = new Membership(id, description, numberDaysEnabled, price, companyId, isActive);

        this.repository.save(membership);
    }
}
