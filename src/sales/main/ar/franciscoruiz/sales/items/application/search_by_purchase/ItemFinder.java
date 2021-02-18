package ar.franciscoruiz.sales.items.application.search_by_purchase;

import ar.franciscoruiz.sales.items.application.ItemResponse;
import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.items.domain.services.search_by_purchase.ItemByPurchaseDomainFinder;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class ItemFinder {
    private final ItemByPurchaseDomainFinder finder;

    public ItemFinder(ItemRepository repository) {
        this.finder = new ItemByPurchaseDomainFinder(repository);
    }

    public ItemsResponse find(PurchaseId purchaseId) {
        return new ItemsResponse(
            this.finder.find(purchaseId)
                .stream()
                .map(ItemResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
