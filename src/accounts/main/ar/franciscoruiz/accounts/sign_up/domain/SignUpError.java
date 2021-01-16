package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class SignUpError extends DomainError {
    public SignUpError() {
        super("sign_up_error", "User registration failed, please try again");
    }
}
