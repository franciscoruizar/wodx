package ar.franciscoruiz.sales.products.application.membership.search_by_company;

import ar.franciscoruiz.sales.products.application.membership.MembershipsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class SearchMembershipsByCompanyQueryHandler implements QueryHandler<SearchMembershipsByCompanyQuery, MembershipsResponse> {
    private final MembershipsByCompanySearcher searcher;

    public SearchMembershipsByCompanyQueryHandler(MembershipsByCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public MembershipsResponse handle(SearchMembershipsByCompanyQuery query) {
        CompanyId companyId = new CompanyId(query.companyId());

        return this.searcher.search(companyId);
    }
}
