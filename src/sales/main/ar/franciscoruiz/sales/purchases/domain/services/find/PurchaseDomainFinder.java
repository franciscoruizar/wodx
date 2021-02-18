package ar.franciscoruiz.sales.purchases.domain.services.find;

import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseNotExits;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseDomainFinder {
    private final PurchaseRepository repository;

    public PurchaseDomainFinder(PurchaseRepository repository) {
        this.repository = repository;
    }

    public Purchase find(PurchaseId id) {
        return this.repository.search(id).orElseThrow(() -> new PurchaseNotExits(id));
    }
}
