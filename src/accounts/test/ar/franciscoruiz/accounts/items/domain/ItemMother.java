package ar.franciscoruiz.accounts.items.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipIdMother;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseIdMother;

public final class ItemMother {
    public static Item create(ItemId id, PurchaseId purchaseId, ItemQuantity quantity, MembershipId membershipId) {
        return new Item(id, purchaseId, quantity, membershipId);
    }

    public static Item random() {
        return create(ItemIdMother.random(), PurchaseIdMother.random(), ItemQuantityMother.random(), MembershipIdMother.random());
    }
}
