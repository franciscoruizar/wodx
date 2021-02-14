package ar.franciscoruiz.sales.items.application.find_by_purchase;

import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindItemByPurchaseQueryHandler implements QueryHandler<FindItemByPurchaseQuery, ItemsResponse> {
    private final ItemByPurchaseFinder finder;

    public FindItemByPurchaseQueryHandler(ItemByPurchaseFinder finder) {
        this.finder = finder;
    }

    @Override
    public ItemsResponse handle(FindItemByPurchaseQuery query) {
        PurchaseId purchaseId = new PurchaseId(query.purchaseId());

        return this.finder.find(purchaseId);
    }
}
