package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.sales.products.domain.membership.MembershipMother;
import ar.franciscoruiz.sales.products.domain.membership.MembershipNumberDaysEnabledMother;
import ar.franciscoruiz.sales.purchases.PurchasesModuleUnitTestCase;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseMother;
import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.sales.purchases.domain.items.ItemMother;
import ar.franciscoruiz.shared.domain.companies.CompanyIdMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

final class PurchaseCreatorShould extends PurchasesModuleUnitTestCase {
    @Test
    void create_a_valid_purchase() {
        ProductFinder   productFinder = new ProductFinder(productRepository);
        PurchaseCreator creator       = new PurchaseCreator(repository, itemRepository, productFinder);

        Purchase purchase = PurchaseMother.random();

        List<Item> items = new ArrayList<>() {{
            add(ItemMother.random());
            add(ItemMother.random());
            add(ItemMother.random());
        }};

        for (var item : items) {
            Product product = MembershipMother.create(
                item.productId(),
                ProductTitleMother.random(),
                ProductDescriptionMother.random(),
                new ProductPrice(item.unitPrice().value()),
                CompanyIdMother.random(),
                ProductIsActiveMother.random(),
                MembershipNumberDaysEnabledMother.random()
            );

            Assertions.assertEquals(item.unitPrice().value(), product.price().value());

            super.mockProductRepositorySearch(product);
        }

        super.mockRepositorySearch(purchase);

        creator.create(purchase.id(), purchase.description(), purchase.date(), purchase.userId(), purchase.companyId(), items);

        shouldSave(purchase);
        shouldHaveSaved(purchase);
    }
}
