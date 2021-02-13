package ar.franciscoruiz.sales.purchases.infrastructure;

import ar.franciscoruiz.sales.purchases.PurchasesModuleInfrastructureTestCase;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernatePurchasesRepositoryShould extends PurchasesModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getPurchases")
    void create_a_valid_purchase(Purchase purchase) {
        repository.save(purchase);
    }

    @ParameterizedTest
    @MethodSource("getPurchases")
    void search_a_valid_purchase(Purchase purchase) {
        repository.save(purchase);

        Assertions.assertEquals(Optional.of(purchase), repository.search(purchase.id()));
    }

    @ParameterizedTest
    @MethodSource("getPurchases")
    void search_a_non_valid_purchase(Purchase purchase) {
        Assertions.assertFalse(repository.search(purchase.id()).isPresent());
    }

    private List<? extends Purchase> getPurchases() {
        return Arrays.asList(PurchaseMother.random(), PurchaseMother.random());
    }
}
