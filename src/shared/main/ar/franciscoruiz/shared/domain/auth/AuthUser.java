package ar.franciscoruiz.shared.domain.auth;

public final class AuthUser {
    private final AuthEmail    email;
    private final AuthPassword password;
    private final Authorities  authorities;

    public AuthUser(AuthEmail email, AuthPassword password, Authorities authorities) {
        this.email       = email;
        this.password    = password;
        this.authorities = authorities;
    }

    public AuthEmail email() {
        return this.email;
    }

    public AuthPassword password() {
        return this.password;
    }

    public Authorities authorities() {
        return this.authorities;
    }

    public boolean passwordMatches(AuthPassword password) {
        return this.password.equals(password);
    }
}
