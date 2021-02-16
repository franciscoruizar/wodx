package ar.franciscoruiz.sales.products.application.membership.search_by_company;

import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.application.membership.MembershipsResponse;
import ar.franciscoruiz.sales.products.domain.membership.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.stream.Collectors;

@Service
public final class MembershipsByCompanySearcher {
    private final MembershipRepository repository;

    public MembershipsByCompanySearcher(MembershipRepository repository) {
        this.repository = repository;
    }

    public MembershipsResponse search(CompanyId companyId) {
        return new MembershipsResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(MembershipResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
