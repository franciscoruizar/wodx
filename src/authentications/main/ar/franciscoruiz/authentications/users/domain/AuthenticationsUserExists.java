package ar.franciscoruiz.authentications.users.domain;

public final class AuthenticationsUserExists extends RuntimeException {
    public AuthenticationsUserExists() {
        super("The user exists");
    }
}
