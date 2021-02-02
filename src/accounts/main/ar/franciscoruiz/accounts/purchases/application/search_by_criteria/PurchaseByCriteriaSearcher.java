package ar.franciscoruiz.accounts.purchases.application.search_by_criteria;

import ar.franciscoruiz.accounts.purchases.application.PurchaseResponse;
import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.accounts.purchases.application.calculator.TotalPriceCalculator;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemsResponse;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemByPurchaseFinder;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class PurchaseByCriteriaSearcher {
    private final PurchaseRepository           repository;
    private final PurchaseItemByPurchaseFinder itemsFinder;

    public PurchaseByCriteriaSearcher(PurchaseRepository repository, PurchaseItemByPurchaseFinder itemsFinder) {
        this.repository  = repository;
        this.itemsFinder = itemsFinder;
    }

    public PurchasesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new PurchasesResponse(
            this.repository
                .matching(criteria)
                .stream()
                .map(purchase -> {
                    PurchaseId id = new PurchaseId(purchase.id());

                    PurchaseItemsResponse items = itemsFinder.find(id);

                    return new PurchaseResponse(
                        purchase.id(),
                        purchase.description(),
                        purchase.date(),
                        purchase.userId(),
                        getTotalPrice(items),
                        items
                    );
                })
                .collect(Collectors.toList())
        );
    }

    private double getTotalPrice(PurchaseItemsResponse items) {
        var calculator = new TotalPriceCalculator(items);

        return calculator.calculate();
    }
}
