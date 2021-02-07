package ar.franciscoruiz.accounts.items.infrastructure;

import ar.franciscoruiz.accounts.items.ItemsModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.items.domain.Item;
import ar.franciscoruiz.accounts.items.domain.ItemMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateItemsRepositoryShould extends ItemsModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getItems")
    void create_a_valid_purchase_item(Item item) {
        repository.save(item);
    }

    @ParameterizedTest
    @MethodSource("getItems")
    void search_a_valid_purchase_item(Item item) {
        repository.save(item);

        Assertions.assertEquals(Optional.of(item), repository.search(item.id()));
    }

    @ParameterizedTest
    @MethodSource("getItems")
    void search_a_non_valid_purchase_item(Item item) {
        Assertions.assertFalse(repository.search(item.id()).isPresent());
    }

    private List<? extends Item> getItems() {
        return Arrays.asList(ItemMother.random(), ItemMother.random());
    }
}
