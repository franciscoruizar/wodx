package ar.franciscoruiz.accounts.purchase_items.domain;

import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;

import java.util.List;
import java.util.Optional;

public interface PurchaseItemRepository {
    void save(PurchaseItem purchaseItem);

    Optional<PurchaseItem> search(PurchaseItemId id);

    List<PurchaseItem> findByPurchaseId(PurchaseId id);
}
