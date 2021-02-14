package ar.franciscoruiz.sales.purchases.application.search_by_user;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.stream.Collectors;

@Service
public final class PurchaseByUserSearcher {
    private final PurchaseRepository repository;

    public PurchaseByUserSearcher(PurchaseRepository repository) {
        this.repository = repository;
    }

    public PurchasesResponse search(UserId userId) {
        return new PurchasesResponse(
            this.repository.searchByUser(userId)
                .stream()
                .map(PurchaseResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
