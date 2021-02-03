package ar.franciscoruiz.accounts.memberships.application.find;

import ar.franciscoruiz.accounts.memberships.MembershipsModuleUnitTestCase;
import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainFinder;
import ar.franciscoruiz.accounts.memberships.domain.MembershipMother;
import org.junit.jupiter.api.Test;

final class MembershipFinderShould extends MembershipsModuleUnitTestCase {
    @Test
    void find_a_valid_membership() {
        MembershipFinder finder = new MembershipFinder(new MembershipDomainFinder(repository));

        Membership membership = MembershipMother.random();

        super.mockRepositorySearch(membership);

        finder.find(membership.id());
    }
}
