package ar.franciscoruiz.sales.products.application.membership.find;

import ar.franciscoruiz.sales.products.ProductsModuleUnitTestCase;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.sales.products.domain.membership.MembershipMother;
import org.junit.jupiter.api.Test;

final class MembershipFinderShould extends ProductsModuleUnitTestCase {
    @Test
    void find_a_valid_membership() {
        MembershipFinder finder = new MembershipFinder(membershipRepository);

        Membership membership = MembershipMother.random();

        super.mockRepositorySearch(membership);

        finder.find(membership.id());
    }
}
