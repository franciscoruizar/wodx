package ar.franciscoruiz.accounts.user_memberships.application.search_by_membership;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchUserMembershipByMembershipQueryHandler implements QueryHandler<SearchUserMembershipByMembershipQuery, UserMembershipsResponse> {
    private final UserMembershipByMembershipSearcher searcher;

    public SearchUserMembershipByMembershipQueryHandler(UserMembershipByMembershipSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public UserMembershipsResponse handle(SearchUserMembershipByMembershipQuery query) {
        MembershipId membershipId = new MembershipId(query.id());

        return searcher.search(membershipId);
    }
}
