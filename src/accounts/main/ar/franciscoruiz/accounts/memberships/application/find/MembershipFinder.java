package ar.franciscoruiz.accounts.memberships.application.find;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainFinder;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipNotExist;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipFinder {
    private final MembershipDomainFinder finder;

    public MembershipFinder(MembershipDomainFinder finder) {
        this.finder = finder;
    }

    public MembershipResponse find(MembershipId id) {
        return this.finder
            .find(id)
            .map(MembershipResponse::fromAggregate)
            .orElseThrow(() -> new MembershipNotExist(id));
    }
}
