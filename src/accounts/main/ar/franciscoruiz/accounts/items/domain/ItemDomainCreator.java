package ar.franciscoruiz.accounts.items.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ItemDomainCreator {
    private final PurchaseItemRepository repository;

    public ItemDomainCreator(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    public void create(
        ItemId id,
        PurchaseId purchaseId,
        ItemQuantity quantity,
        MembershipId membershipId
    ) {
        Item item = new Item(id, purchaseId, quantity, membershipId);

        this.repository.save(item);
    }
}
