package ar.franciscoruiz.accounts.purchases.application.find;

import ar.franciscoruiz.accounts.purchases.PurchasesModuleUnitTestCase;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseMother;
import org.junit.jupiter.api.Test;

final class PurchaseFinderShould extends PurchasesModuleUnitTestCase {
    @Test
    void find_a_valid_purchase() {
        PurchaseFinder finder = new PurchaseFinder(repository);

        Purchase purchase = PurchaseMother.random();

        super.mockRepositorySearch(purchase);

        finder.find(purchase.id());
    }
}
