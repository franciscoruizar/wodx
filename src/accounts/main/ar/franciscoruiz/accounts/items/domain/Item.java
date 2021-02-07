package ar.franciscoruiz.accounts.items.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;

public final class Item {
    private final ItemId     id;
    private final PurchaseId   purchaseId;
    private final ItemQuantity quantity;
    private final MembershipId membershipId;

    public Item(
        ItemId id,
        PurchaseId purchaseId,
        ItemQuantity quantity,
        MembershipId membershipId
    ) {
        this.id           = id;
        this.purchaseId   = purchaseId;
        this.quantity     = quantity;
        this.membershipId = membershipId;
    }

    private Item() {
        this.id           = null;
        this.purchaseId   = null;
        this.quantity     = null;
        this.membershipId = null;
    }

    public ItemId id() {
        return this.id;
    }

    public PurchaseId purchaseId() {
        return this.purchaseId;
    }

    public ItemQuantity quantity() {
        return this.quantity;
    }

    public MembershipId membershipId() {
        return this.membershipId;
    }
}
