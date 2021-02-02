package ar.franciscoruiz.authentications.users.application.create;

import ar.franciscoruiz.authentications.users.UsersModuleUnitTestCase;
import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.authentications.users.domain.UserFinderDomain;
import ar.franciscoruiz.authentications.users.domain.UserMother;
import org.junit.jupiter.api.Test;

final class UserCreatorShould extends UsersModuleUnitTestCase {
    @Test
    void create_a_valid_user() {
        UserCreator creator = new UserCreator(repository, new UserFinderDomain(repository));

        User user = UserMother.random();

        super.mockRepositorySearch(user);

        creator.create(user.id(), user.name(), user.surname(), user.email(), user.phone(), user.isActive(), user.roleId());

        shouldSave(user);
        shouldHaveSaved(user);
    }
}
