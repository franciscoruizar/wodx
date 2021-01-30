package ar.franciscoruiz.accounts.purchases.domain.items.domain;

import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseItemFinder {
    private final PurchaseItemRepository repository;

    public PurchaseItemFinder(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    public PurchaseItem find(PurchaseItemId id) {
        return this.repository.search(id).orElseThrow(() -> new PurchaseItemNotExits(id));
    }
}
