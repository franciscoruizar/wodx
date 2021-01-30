package ar.franciscoruiz.accounts.purchases.application.finder;

import ar.franciscoruiz.accounts.purchases.application.PurchaseResponse;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseNotExits;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemResponse;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemsResponse;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemByPurchaseFinder;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseFinder {
    private final PurchaseRepository           repository;
    private final PurchaseItemByPurchaseFinder itemsFinder;

    public PurchaseFinder(PurchaseRepository repository, PurchaseItemByPurchaseFinder itemsFinder) {
        this.repository  = repository;
        this.itemsFinder = itemsFinder;
    }

    public PurchaseResponse find(PurchaseId id) {
        Purchase purchase = this.repository.search(id).orElseThrow(() -> new PurchaseNotExits(id));

        PurchaseItemsResponse items = itemsFinder.find(id);

        return new PurchaseResponse(
            purchase.id(),
            purchase.description(),
            purchase.date(),
            purchase.userId(),
            getTotalPrice(items),
            items
        );
    }

    private double getTotalPrice(PurchaseItemsResponse items) {
        return items.items().stream().mapToDouble(PurchaseItemResponse::price).sum();
    }
}
