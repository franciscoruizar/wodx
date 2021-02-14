package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    void save(Purchase purchase);

    Optional<Purchase> search(PurchaseId id);

    List<Purchase> searchByUser(UserId userId);

    List<Purchase> searchByCompany(CompanyId companyId);

    List<Purchase> searchByUserCompany(UserId userId, CompanyId companyId);
}
