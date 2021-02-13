package ar.franciscoruiz.accounts.memberships.application.search_by_company;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.accounts.memberships.application.MembershipsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchMembershipByCompanyQueryHandler implements QueryHandler<SearchMembershipByCompany, MembershipsResponse> {
    private final MembershipByCompanySearcher searcher;

    public SearchMembershipByCompanyQueryHandler(MembershipByCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public MembershipsResponse handle(SearchMembershipByCompany query) {
        CompanyId companyId = new CompanyId(query.companyId());

        return searcher.search(companyId);
    }
}
