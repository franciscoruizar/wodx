package ar.franciscoruiz.accounts.users.application.find;

import ar.franciscoruiz.accounts.users.UsersModuleUnitTestCase;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import org.junit.jupiter.api.Test;

final class UserFinderShould extends UsersModuleUnitTestCase {
    @Test
    void find_a_valid_user() {
        UserFinder finder = new UserFinder(repository);

        User user = UserMother.random();

        super.mockRepositorySearch(user);

        finder.find(new UserId(user.id()));
    }
}
