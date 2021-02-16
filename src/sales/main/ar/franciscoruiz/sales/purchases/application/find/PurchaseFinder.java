package ar.franciscoruiz.sales.purchases.application.find;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseNotExits;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseFinder {
    private final PurchaseRepository repository;

    public PurchaseFinder(PurchaseRepository repository) {
        this.repository = repository;
    }

    public PurchaseResponse find(PurchaseId id) {
        Purchase purchase = this.repository.search(id).orElseThrow(() -> new PurchaseNotExits(id));

        double totalPrice = 0.0;

        for (var item : purchase.items())
            totalPrice += item.unitPrice().value();

        return PurchaseResponse.fromAggregate(purchase, totalPrice);
    }
}
