package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.sales.purchases.domain.items.ItemMother;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.companies.CompanyIdMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.domain.users.UserIdMother;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class PurchaseMother {
    public static Purchase create(PurchaseId id, PurchaseDescription description, LocalDateTime date, UserId userId, CompanyId companyId, List<Item> items) {
        return new Purchase(id, description, date, userId, companyId, items);
    }

    public static Purchase random() {
        List<Item> items = Collections.singletonList(ItemMother.random());
        return create(PurchaseIdMother.random(), PurchaseDescriptionMother.random(), LocalDateTime.now(), UserIdMother.random(), CompanyIdMother.random(), items);
    }
}
