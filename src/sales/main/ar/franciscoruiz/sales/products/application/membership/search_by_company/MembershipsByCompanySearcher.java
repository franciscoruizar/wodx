package ar.franciscoruiz.sales.products.application.membership.search_by_company;

import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.application.membership.MembershipsResponse;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.stream.Collectors;

@Service
public final class MembershipsByCompanySearcher {
    private final ProductRepository repository;

    public MembershipsByCompanySearcher(ProductRepository repository) {
        this.repository = repository;
    }

    public MembershipsResponse search(CompanyId companyId) {
        return new MembershipsResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(product -> MembershipResponse.fromAggregate((Membership) product))
                .collect(Collectors.toList())
        );
    }
}
