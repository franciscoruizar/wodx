package ar.franciscoruiz.authentications.users.domain;

public final class UserExists extends RuntimeException {
    public UserExists() {
        super("The user exists");
    }
}
