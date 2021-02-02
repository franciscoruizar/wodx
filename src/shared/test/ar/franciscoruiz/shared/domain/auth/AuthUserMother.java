package ar.franciscoruiz.shared.domain.auth;

public final class AuthUserMother {
    public static AuthUser create(AuthEmail email, AuthPassword password, Authorities authorities) {
        return new AuthUser(email, password, authorities);
    }

    public static AuthUser random() {
        return create(AuthEmailMother.random(), AuthPasswordMother.random(), AuthoritiesMother.random());
    }
}
