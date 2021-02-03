package ar.franciscoruiz.accounts.purchase_items.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseItemDomainCreator {
    private final PurchaseItemRepository repository;

    public PurchaseItemDomainCreator(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    public void create(
        PurchaseItemId id,
        PurchaseId purchaseId,
        PurchaseItemQuantity quantity,
        MembershipId membershipId
    ) {
        PurchaseItem item = new PurchaseItem(id, purchaseId, quantity, membershipId);

        this.repository.save(item);
    }
}
