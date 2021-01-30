package ar.franciscoruiz.accounts.user_memberships.application.find;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipResponse;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserMembershipQueryHandler implements QueryHandler<FindUserMembershipQuery, UserMembershipResponse> {
    private final UserMembershipFinder finder;

    public FindUserMembershipQueryHandler(UserMembershipFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserMembershipResponse handle(FindUserMembershipQuery query) {
        UserMembershipId id = new UserMembershipId(query.id());

        return this.finder.find(id);
    }
}
