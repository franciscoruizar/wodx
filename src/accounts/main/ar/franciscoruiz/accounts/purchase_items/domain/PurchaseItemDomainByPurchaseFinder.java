package ar.franciscoruiz.accounts.purchase_items.domain;

import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.List;

@Service
public final class PurchaseItemDomainByPurchaseFinder {
    private final PurchaseItemRepository repository;

    public PurchaseItemDomainByPurchaseFinder(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseItem> find(PurchaseId id) {
        return this.repository.findByPurchaseId(id);
    }

}
