package ar.franciscoruiz.accounts.users.infrastructure;

import ar.franciscoruiz.accounts.users.UsersModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateUserRepositoryShould extends UsersModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getUsers")
    void search_a_valid_user(User user) {
        repository.save(user);

        Assertions.assertEquals(Optional.of(user), repository.search(new UserId(user.id())));
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void search_a_non_valid_user(User user) {
        Assertions.assertFalse(repository.search(new UserId(user.id())).isPresent());
    }

    private List<? extends User> getUsers() {
        return Arrays.asList(UserMother.random(), UserMother.random());
    }
}
