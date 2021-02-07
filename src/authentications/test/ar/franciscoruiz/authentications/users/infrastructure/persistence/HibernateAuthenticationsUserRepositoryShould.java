package ar.franciscoruiz.authentications.users.infrastructure.persistence;

import ar.franciscoruiz.authentications.users.AuthenticationsUsersModuleInfrastructureTestCase;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUser;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateAuthenticationsUserRepositoryShould extends AuthenticationsUsersModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getUsers")
    void create_a_valid_user(AuthenticationsUser user) {
        repository.save(user);
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void search_a_valid_user(AuthenticationsUser user) {
        repository.save(user);

        Assertions.assertEquals(Optional.of(user), repository.search(user.id()));
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void search_a_non_valid_user(AuthenticationsUser user) {
        Assertions.assertFalse(repository.search(user.id()).isPresent());
    }

    private List<? extends AuthenticationsUser> getUsers() {
        return Arrays.asList(AuthenticationsUserMother.random(), AuthenticationsUserMother.random());
    }
}
