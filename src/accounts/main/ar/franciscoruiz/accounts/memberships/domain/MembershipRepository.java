package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository {
    void save(Membership membership);

    Optional<Membership> search(MembershipId id);

    List<Membership> findByCompany(CompanyId companyId);
}
