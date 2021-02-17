package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.companies.CompanyIdMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.domain.users.UserIdMother;

import java.time.LocalDateTime;

public final class PurchaseMother {
    public static Purchase create(PurchaseId id, PurchaseDescription description, LocalDateTime date, UserId userId, CompanyId companyId) {
        return new Purchase(id, description, date, userId, companyId);
    }

    public static Purchase random() {
        return create(PurchaseIdMother.random(), PurchaseDescriptionMother.random(), LocalDateTime.now(), UserIdMother.random(), CompanyIdMother.random());
    }
}
