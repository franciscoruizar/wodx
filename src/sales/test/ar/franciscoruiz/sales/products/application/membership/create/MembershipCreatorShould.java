package ar.franciscoruiz.sales.products.application.membership.create;

import ar.franciscoruiz.sales.products.ProductsModuleUnitTestCase;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.sales.products.domain.membership.MembershipMother;
import org.junit.jupiter.api.Test;

final class MembershipCreatorShould extends ProductsModuleUnitTestCase {
    @Test
    void create_a_valid_membership() {
        MembershipCreator creator = new MembershipCreator(repository);

        Membership membership = MembershipMother.random();

        super.mockRepositorySearch(membership);

        creator.create(membership.id(), membership.title(), membership.description(), membership.price(), membership.isActive(), membership.companyId(), membership.numberDaysEnabled());

        shouldSave(membership);
        shouldHaveSaved(membership);
    }
}
