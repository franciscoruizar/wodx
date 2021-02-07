package ar.franciscoruiz.authentications.auth.application.authenticate;

import ar.franciscoruiz.authentications.auth.AuthModuleUnitTestCase;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUserMother;
import org.junit.jupiter.api.Test;

final class AuthAuthenticationsUserAuthenticatorShould extends AuthModuleUnitTestCase {
    @Test
    void authenticate_a_valid_user() {
        AuthUserAuthenticator authenticator = new AuthUserAuthenticator(repository, encoder);

        AuthUser user = AuthUserMother.random();

        mockPasswordEncoderEncode(user.password().value());
        mockPasswordEncoderMatch(user.password().value(), user.password().value());

        super.mockRepositorySearch(user);

        authenticator.authenticate(user.email(), user.password());
    }
}
