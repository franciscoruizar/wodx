package ar.franciscoruiz.sales.items.application.search_by_purchase;

import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindItemQueryHandler implements QueryHandler<FindItemQuery, ItemsResponse> {
    private final ItemFinder finder;

    public FindItemQueryHandler(ItemFinder finder) {
        this.finder = finder;
    }

    @Override
    public ItemsResponse handle(FindItemQuery query) {
        PurchaseId id = new PurchaseId(query.id());

        return this.finder.find(id);
    }
}
