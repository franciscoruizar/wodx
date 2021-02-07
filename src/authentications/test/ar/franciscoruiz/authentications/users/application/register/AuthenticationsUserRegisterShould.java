package ar.franciscoruiz.authentications.users.application.register;

import ar.franciscoruiz.authentications.users.AuthenticationsUsersModuleUnitTestCase;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUser;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserFinderDomain;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserMother;
import org.junit.jupiter.api.Test;

final class AuthenticationsUserRegisterShould extends AuthenticationsUsersModuleUnitTestCase {
    @Test
    void create_a_valid_user() {
        UserRegister creator = new UserRegister(repository, new AuthenticationsUserFinderDomain(repository));

        AuthenticationsUser user = AuthenticationsUserMother.random();

        super.mockRepositorySearch(user);

        creator.create(user.id(), user.name(), user.surname(), user.email(), user.phone(), user.roleId());

        shouldSave(user);
        shouldHaveSaved(user);
    }
}
