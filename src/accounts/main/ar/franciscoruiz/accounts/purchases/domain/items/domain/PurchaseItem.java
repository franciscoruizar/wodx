package ar.franciscoruiz.accounts.purchases.domain.items.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;

public final class PurchaseItem {
    private final PurchaseItemId       id;
    private final PurchaseId           purchaseId;
    private final PurchaseItemQuantity quantity;
    private final MembershipId         membershipId;

    public PurchaseItem(
        PurchaseItemId id,
        PurchaseId purchaseId,
        PurchaseItemQuantity quantity,
        MembershipId membershipId
    ) {
        this.id           = id;
        this.purchaseId   = purchaseId;
        this.quantity     = quantity;
        this.membershipId = membershipId;
    }

    public PurchaseItemId id() {
        return this.id;
    }

    public PurchaseId purchaseId() {
        return this.purchaseId;
    }

    public PurchaseItemQuantity quantity() {
        return this.quantity;
    }

    public MembershipId membershipId() {
        return this.membershipId;
    }
}
