package ar.franciscoruiz.accounts.purchase_items.infrastructure;

import ar.franciscoruiz.accounts.purchase_items.PurchaseItemsModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItem;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemMother;
import ar.franciscoruiz.accounts.purchases.PurchasesModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernatePurchaseItemsRepositoryShould extends PurchaseItemsModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getItems")
    void create_a_valid_purchase_item(PurchaseItem item) {
        repository.save(item);
    }

    @ParameterizedTest
    @MethodSource("getItems")
    void search_a_valid_purchase_item(PurchaseItem item) {
        repository.save(item);

        Assertions.assertEquals(Optional.of(item), repository.search(item.id()));
    }

    @ParameterizedTest
    @MethodSource("getItems")
    void search_a_non_valid_purchase_item(PurchaseItem item) {
        Assertions.assertFalse(repository.search(item.id()).isPresent());
    }

    private List<? extends PurchaseItem> getItems() {
        return Arrays.asList(PurchaseItemMother.random(), PurchaseItemMother.random());
    }
}
