package ar.franciscoruiz.sales.purchases.application.find;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindPurchaseQueryHandler implements QueryHandler<FindPurchaseQuery, PurchaseResponse> {
    private final PurchaseFinder finder;

    public FindPurchaseQueryHandler(PurchaseFinder finder) {
        this.finder = finder;
    }

    @Override
    public PurchaseResponse handle(FindPurchaseQuery query) {
        PurchaseId id = new PurchaseId(query.id());

        return this.finder.find(id);
    }
}
