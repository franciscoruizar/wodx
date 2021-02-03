package ar.franciscoruiz.accounts.purchases.application.find;

import ar.franciscoruiz.accounts.purchases.application.PurchaseResponse;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseNotExits;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseFinder {
    private final PurchaseRepository repository;

    public PurchaseFinder(PurchaseRepository repository) {
        this.repository = repository;
    }

    public PurchaseResponse find(PurchaseId id) {
        Purchase purchase = this.repository.search(id).orElseThrow(() -> new PurchaseNotExits(id));

        return PurchaseResponse.fromAggregate(purchase);
    }
}
