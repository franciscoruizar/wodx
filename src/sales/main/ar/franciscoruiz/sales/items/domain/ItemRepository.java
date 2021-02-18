package ar.franciscoruiz.sales.items.domain;


import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.util.List;

public interface ItemRepository {
    void save(Item item);

    List<Item> findByPurchase(PurchaseId id);
}
