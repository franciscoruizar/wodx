package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.Service;

import java.util.Optional;

@Service
public final class MembershipDomainFinder {
    private final MembershipRepository repository;

    public MembershipDomainFinder(MembershipRepository repository) {
        this.repository = repository;
    }

    public Optional<Membership> find(MembershipId id) {
        return this.repository.search(id);
    }
}
