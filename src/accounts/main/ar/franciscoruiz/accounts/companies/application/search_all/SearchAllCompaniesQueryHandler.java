package ar.franciscoruiz.accounts.companies.application.search_all;

import ar.franciscoruiz.accounts.companies.application.CompaniesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllCompaniesQueryHandler implements QueryHandler<SearchAllCompaniesQuery, CompaniesResponse> {
    private final AllCompaniesSearcher searcher;

    public SearchAllCompaniesQueryHandler(AllCompaniesSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public CompaniesResponse handle(SearchAllCompaniesQuery query) {
        return this.searcher.search();
    }
}
