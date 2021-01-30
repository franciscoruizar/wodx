package ar.franciscoruiz.accounts.memberships.application.find;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipNotExist;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipFinder {
    private final MembershipRepository repository;

    public MembershipFinder(MembershipRepository repository) {
        this.repository = repository;
    }

    public MembershipResponse find(MembershipId id) {
        return this.repository
            .search(id)
            .map(MembershipResponse::fromAggregate)
            .orElseThrow(() -> new MembershipNotExist(id));
    }
}
