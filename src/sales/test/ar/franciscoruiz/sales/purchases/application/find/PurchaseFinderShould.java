package ar.franciscoruiz.sales.purchases.application.find;

import ar.franciscoruiz.sales.purchases.PurchasesModuleUnitTestCase;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseMother;
import org.junit.jupiter.api.Test;

final class PurchaseFinderShould extends PurchasesModuleUnitTestCase {
    @Test
    void find_a_valid_purchase() {
        PurchaseFinder finder = new PurchaseFinder(repository, itemRepository);

        Purchase purchase = PurchaseMother.random();

        super.mockRepositorySearch(purchase);

        finder.find(purchase.id());
    }
}
