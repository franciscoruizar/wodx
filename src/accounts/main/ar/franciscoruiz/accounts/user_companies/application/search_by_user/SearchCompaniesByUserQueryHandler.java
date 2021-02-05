package ar.franciscoruiz.accounts.user_companies.application.search_by_user;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class SearchCompaniesByUserQueryHandler implements QueryHandler<SearchCompaniesByUserQuery, CompaniesByUserResponse> {
    private final CompaniesByUserSearcher searcher;

    public SearchCompaniesByUserQueryHandler(CompaniesByUserSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public CompaniesByUserResponse handle(SearchCompaniesByUserQuery query) {
        UserId userId = new UserId(query.userId());

        return this.searcher.search(userId);
    }
}
