package ar.franciscoruiz.accounts.user_memberships.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class UserMembershipNotExist extends DomainError {
    public UserMembershipNotExist(UserMembershipId id) {
        super("user_membership_not_exist", String.format("The user membership <%s> doesn't exist", id.value()));
    }
}
