package ar.franciscoruiz.accounts.purchases.application.create;

import ar.franciscoruiz.accounts.purchases.PurchasesModuleUnitTestCase;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseMother;
import org.junit.jupiter.api.Test;

final class PurchaseCreatorShould extends PurchasesModuleUnitTestCase {
    @Test
    void create_a_valid_purchase() {
        PurchaseCreator creator = new PurchaseCreator(repository);

        Purchase purchase = PurchaseMother.random();

        super.mockRepositorySearch(purchase);

        creator.create(purchase.id(), purchase.description(), purchase.date(), purchase.userId(), purchase.companyId());

        shouldSave(purchase);
        shouldHaveSaved(purchase);
    }
}
