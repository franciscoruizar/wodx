package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class UserNotExist extends DomainError {
    public UserNotExist(UserId id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id.value()));
    }
}
