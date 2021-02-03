package ar.franciscoruiz.accounts.purchases.domain;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    void save(Purchase purchase);

    Optional<Purchase> search(PurchaseId id);

    List<Purchase> searchByCompany(CompanyId companyId);
}
