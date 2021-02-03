package ar.franciscoruiz.authentications.auth.infrastructure.persistence;

import ar.franciscoruiz.authentications.auth.AuthModuleInfrastructureTestCase;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUserMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
class HibernateAuthAuthUserRepositoryShould extends AuthModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getAuthUsers")
    void search_a_non_valid_auth_user(AuthUser authUser) {
        Assertions.assertFalse(repository.search(authUser.email()).isPresent());
    }

    private List<? extends AuthUser> getAuthUsers() {
        return Arrays.asList(AuthUserMother.random(), AuthUserMother.random());
    }
}
