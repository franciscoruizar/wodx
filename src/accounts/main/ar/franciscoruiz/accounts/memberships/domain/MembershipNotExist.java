package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class MembershipNotExist extends DomainError {
    public MembershipNotExist(MembershipId id) {
        super("membership_not_exist", String.format("The membership <%s> doesn't exist", id.value()));
    }
}
