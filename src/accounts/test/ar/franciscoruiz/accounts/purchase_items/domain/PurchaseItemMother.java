package ar.franciscoruiz.accounts.purchase_items.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipIdMother;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseIdMother;

public final class PurchaseItemMother {
    public static PurchaseItem create(PurchaseItemId id, PurchaseId purchaseId, PurchaseItemQuantity quantity, MembershipId membershipId) {
        return new PurchaseItem(id, purchaseId, quantity, membershipId);
    }

    public static PurchaseItem random() {
        return create(PurchaseItemIdMother.random(), PurchaseIdMother.random(), PurchaseItemQuantityMother.random(), MembershipIdMother.random());
    }
}
