package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;

@Service
public final class PurchaseCreator {
    private final PurchaseRepository repository;

    public PurchaseCreator(PurchaseRepository repository) {
        this.repository = repository;
    }

    public void create(
        PurchaseId id,
        PurchaseDescription description,
        LocalDateTime date,
        UserId userId,
        CompanyId companyId
    ) {
        Purchase purchase = new Purchase(id, description, date, userId, companyId);

        this.repository.save(purchase);
    }
}
