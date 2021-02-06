package ar.franciscoruiz.accounts.memberships.infrastructure;

import ar.franciscoruiz.accounts.memberships.MembershipsModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.transaction.Transactional;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateMembershipsRepositoryShould extends MembershipsModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getMemberships")
    void create_a_valid_membership(Membership membership) {
        repository.save(membership);
    }

    @ParameterizedTest
    @MethodSource("getMemberships")
    void search_a_valid_membership(Membership membership) {
        repository.save(membership);

        Assertions.assertEquals(Optional.of(membership), repository.search(membership.id()));
    }

    @ParameterizedTest
    @MethodSource("getMemberships")
    void search_a_non_valid_membership(Membership membership) {
        Assertions.assertFalse(repository.search(membership.id()).isPresent());
    }

    private List<? extends Membership> getMemberships() {
        return Arrays.asList(MembershipMother.random(), MembershipMother.random());
    }
}
