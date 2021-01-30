package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthEmail;

public final class InvalidAuthCredentials extends RuntimeException {
    public InvalidAuthCredentials(AuthEmail email) {
        super(String.format("The credentials for <%s> are invalid", email.value()));
    }
}
