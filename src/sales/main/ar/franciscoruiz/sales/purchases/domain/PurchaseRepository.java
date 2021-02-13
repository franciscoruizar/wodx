package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    void save(Purchase purchase);

    Optional<Purchase> search(PurchaseId id);

    List<Purchase> searchByCompany(CompanyId companyId);
}
