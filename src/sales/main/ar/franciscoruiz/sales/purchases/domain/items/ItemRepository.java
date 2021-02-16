package ar.franciscoruiz.sales.purchases.domain.items;


import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    void save(Item item);

    Optional<Item> search(ItemId id);

    List<Item> findByPurchaseId(PurchaseId id);
}
