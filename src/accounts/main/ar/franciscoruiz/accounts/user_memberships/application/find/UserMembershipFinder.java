package ar.franciscoruiz.accounts.user_memberships.application.find;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipResponse;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipNotExist;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserMembershipFinder {
    private final UserMembershipRepository repository;

    public UserMembershipFinder(UserMembershipRepository repository) {
        this.repository = repository;
    }

    public UserMembershipResponse find(UserMembershipId id) {
        return this.repository
            .search(id)
            .map(UserMembershipResponse::fromAggregate)
            .orElseThrow(() -> new UserMembershipNotExist(id));
    }
}
