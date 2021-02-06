package ar.franciscoruiz.accounts.purchase_items.application.create;

import ar.franciscoruiz.accounts.companies.domain.CompanyIdMother;
import ar.franciscoruiz.accounts.memberships.domain.*;
import ar.franciscoruiz.accounts.purchase_items.PurchaseItemsModuleUnitTestCase;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItem;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemMother;
import org.junit.jupiter.api.Test;

final class PurchaseItemCreatorShould extends PurchaseItemsModuleUnitTestCase {
    @Test
    void create_a_valid_item() {
        PurchaseItemCreator creator = new PurchaseItemCreator(repository, membershipRepository);

        PurchaseItem item = PurchaseItemMother.random();
        Membership membership = MembershipMother.create(
            item.membershipId(),
            MembershipDescriptionMother.random(),
            MembershipNumberDaysEnabledMother.random(),
            MembershipPriceMother.random(),
            CompanyIdMother.random(),
            MembershipIsActiveMother.random()
        );

        mockMembershipRepositorySearch(membership);
        mockRepositorySearch(item);

        creator.create(item.id(), item.purchaseId(), item.quantity(), item.membershipId());

        shouldMembershipSave(membership);
        shouldMembershipHaveSaved(membership);
        shouldSave(item);
        shouldHaveSaved(item);
    }
}
