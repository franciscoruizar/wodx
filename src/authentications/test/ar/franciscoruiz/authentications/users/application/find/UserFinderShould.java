package ar.franciscoruiz.authentications.users.application.find;

import ar.franciscoruiz.authentications.users.UsersModuleUnitTestCase;
import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.authentications.users.domain.UserFinderDomain;
import ar.franciscoruiz.authentications.users.domain.UserMother;
import org.junit.jupiter.api.Test;

final class UserFinderShould extends UsersModuleUnitTestCase {
    @Test
    void find_a_valid_user() {
        UserFinder finder = new UserFinder(new UserFinderDomain(repository));

        User user = UserMother.random();

        super.mockRepositorySearch(user);

        finder.find(user.id());
    }
}
