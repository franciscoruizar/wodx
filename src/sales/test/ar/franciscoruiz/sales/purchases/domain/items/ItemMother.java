package ar.franciscoruiz.sales.purchases.domain.items;

import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductIdMother;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseIdMother;

public final class ItemMother {
    public static Item create(
        ItemId id,
        ItemQuantity quantity,
        ItemUnitPrice unitPrice,
        ProductId productId,
        PurchaseId purchaseId
    ) {
        return new Item(id, quantity, unitPrice, productId, purchaseId);
    }

    public static Item random() {
        return create(
            ItemIdMother.random(),
            ItemQuantityMother.random(),
            ItemUnitPriceMother.random(),
            ProductIdMother.random(),
            PurchaseIdMother.random()
        );
    }
}
