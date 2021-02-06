package ar.franciscoruiz.authentications.users.infrastructure.persistence;

import ar.franciscoruiz.authentications.users.UsersModuleInfrastructureTestCase;
import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.authentications.users.domain.UserMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateAuthUserRepositoryShould extends UsersModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getUsers")
    void create_a_valid_user(User user) {
        repository.save(user);
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void search_a_valid_user(User user) {
        repository.save(user);

        Assertions.assertEquals(Optional.of(user), repository.search(user.id()));
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void search_a_non_valid_user(User user) {
        Assertions.assertFalse(repository.search(user.id()).isPresent());
    }

    private List<? extends User> getUsers() {
        return Arrays.asList(UserMother.random(), UserMother.random());
    }
}
