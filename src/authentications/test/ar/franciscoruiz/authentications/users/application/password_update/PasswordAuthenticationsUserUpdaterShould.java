package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.authentications.users.AuthenticationsUsersModuleUnitTestCase;
import ar.franciscoruiz.authentications.users.domain.*;
import org.junit.jupiter.api.Test;

final class PasswordAuthenticationsUserUpdaterShould extends AuthenticationsUsersModuleUnitTestCase {
    @Test
    void update_password_a_valid_user() {
        PasswordUserUpdater updater = new PasswordUserUpdater(repository, new AuthenticationsUserFinderDomain(repository), encoder);

        AuthenticationsUser user = AuthenticationsUserMother.random();

        AuthenticationsUserPassword password = AuthenticationsUserPasswordMother.random();

        mockRepositorySearch(user);

        mockPasswordEncoderEncode(user.password().value());
        mockPasswordEncoderMatch(user.password().value(), user.password().value());

        updater.update(user.id(), user.password(), password);

        shouldSave(user);
        shouldHaveSaved(user);
    }
}
