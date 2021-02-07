package ar.franciscoruiz.accounts.items.application.create;

import ar.franciscoruiz.accounts.companies.domain.CompanyIdMother;
import ar.franciscoruiz.accounts.memberships.domain.*;
import ar.franciscoruiz.accounts.items.ItemsModuleUnitTestCase;
import ar.franciscoruiz.accounts.items.domain.Item;
import ar.franciscoruiz.accounts.items.domain.ItemMother;
import org.junit.jupiter.api.Test;

final class ItemCreatorShould extends ItemsModuleUnitTestCase {
    @Test
    void create_a_valid_item() {
        ItemCreator creator = new ItemCreator(repository, membershipRepository);

        Item item = ItemMother.random();
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
