package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.authentications.auth.AuthModuleUnitTestCase;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUserMother;
import org.junit.jupiter.api.Test;

final class AuthUserByUsernameFinderShould extends AuthModuleUnitTestCase {
    @Test
    void find_a_valid_user() {
        AuthUserByUsernameFinder finder = new AuthUserByUsernameFinder(repository);

        AuthUser user = AuthUserMother.random();

        super.mockRepositorySearch(user);

        finder.find(user.email());
    }
}
