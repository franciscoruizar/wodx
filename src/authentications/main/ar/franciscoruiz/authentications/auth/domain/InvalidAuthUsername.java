package ar.franciscoruiz.authentications.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthEmail;

public final class InvalidAuthUsername extends RuntimeException {
    public InvalidAuthUsername(AuthEmail email) {
        super(String.format("The user <%s> does not exist", email.value()));
    }
}
