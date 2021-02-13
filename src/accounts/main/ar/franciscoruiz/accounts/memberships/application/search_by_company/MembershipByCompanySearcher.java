package ar.franciscoruiz.accounts.memberships.application.search_by_company;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.application.MembershipsResponse;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class MembershipByCompanySearcher {
    private final MembershipRepository repository;

    public MembershipByCompanySearcher(MembershipRepository repository) {
        this.repository = repository;
    }

    public MembershipsResponse search(CompanyId companyId) {

        return new MembershipsResponse(
            this.repository
                .findByCompany(companyId)
                .stream()
                .map(MembershipResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
