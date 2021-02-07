package ar.franciscoruiz.accounts.items.domain;

import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.List;

@Service
public final class ItemDomainByPurchaseFinder {
    private final PurchaseItemRepository repository;

    public ItemDomainByPurchaseFinder(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> find(PurchaseId id) {
        return this.repository.findByPurchaseId(id);
    }

}
