package ar.franciscoruiz.sales.items.domain.services.search_by_purchase;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.List;

@Service
public final class ItemByPurchaseDomainFinder {
    private final ItemRepository repository;

    public ItemByPurchaseDomainFinder(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> find(PurchaseId purchaseId) {
        return this.repository.findByPurchase(purchaseId);
    }
}
