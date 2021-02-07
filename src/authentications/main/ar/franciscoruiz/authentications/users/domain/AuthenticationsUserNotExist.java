package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class AuthenticationsUserNotExist extends DomainError {
    public AuthenticationsUserNotExist(UserId id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id.value()));
    }

    public AuthenticationsUserNotExist(AuthenticationsUserEmail email) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", email.value()));
    }
}
