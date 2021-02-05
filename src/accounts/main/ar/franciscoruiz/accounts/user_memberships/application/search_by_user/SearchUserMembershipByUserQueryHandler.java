package ar.franciscoruiz.accounts.user_memberships.application.search_by_user;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class SearchUserMembershipByUserQueryHandler implements QueryHandler<SearchUserMembershipByUserQuery, UserMembershipsResponse> {
    private final UserMembershipByUserSearcher searcher;

    public SearchUserMembershipByUserQueryHandler(UserMembershipByUserSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public UserMembershipsResponse handle(SearchUserMembershipByUserQuery query) {
        UserId userId = new UserId(query.id());

        return searcher.search(userId);
    }
}
