package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class UserNotExist extends DomainError {
    public UserNotExist(String id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id));
    }
}
