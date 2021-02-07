package ar.franciscoruiz.accounts.items.domain;

import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;

import java.util.List;
import java.util.Optional;

public interface PurchaseItemRepository {
    void save(Item item);

    Optional<Item> search(ItemId id);

    List<Item> findByPurchaseId(PurchaseId id);
}
