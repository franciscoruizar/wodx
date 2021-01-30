package ar.franciscoruiz.accounts.memberships.application.find;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindMembershipQueryHandler implements QueryHandler<FindMembershipQuery, MembershipResponse> {
    private final MembershipFinder finder;

    public FindMembershipQueryHandler(MembershipFinder finder) {
        this.finder = finder;
    }

    @Override
    public MembershipResponse handle(FindMembershipQuery query) {
        MembershipId id = new MembershipId(query.id());

        return this.finder.find(id);
    }
}
