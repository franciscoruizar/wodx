package ar.franciscoruiz.accounts.purchases.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    void save(Purchase purchase);

    Optional<Purchase> search(PurchaseId id);

    List<Purchase> matching(Criteria criteria);
}
