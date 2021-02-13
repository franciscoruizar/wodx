package ar.franciscoruiz.sales.items.application.find_by_purchase;

import ar.franciscoruiz.sales.items.application.ItemResponse;
import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class ItemByPurchaseFinder {
    private final ItemRepository repository;

    public ItemByPurchaseFinder(ItemRepository repository) {
        this.repository = repository;
    }

    public ItemsResponse find(PurchaseId id) {
        return new ItemsResponse(
            this.repository.findByPurchaseId(id)
                .stream()
                .map(item -> new ItemResponse(
                    item.id().value(),
                    item.purchaseId().value(),
                    item.quantity().value(),
                    item.unitPrice().value(),
                    item.productId().value()
                ))
                .collect(Collectors.toList())
        );
    }
}
