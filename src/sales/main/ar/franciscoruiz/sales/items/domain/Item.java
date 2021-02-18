package ar.franciscoruiz.sales.items.domain;

import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.util.List;

public final class Item {
    private final ItemId        id;
    private final ItemQuantity  quantity;
    private final ItemUnitPrice unitPrice;
    private final ProductId     productId;
    private final PurchaseId    purchaseId;

    public Item(
        ItemId id,
        ItemQuantity quantity,
        ItemUnitPrice unitPrice,
        ProductId productId,
        PurchaseId purchaseId
    ) {
        this.id         = id;
        this.quantity   = quantity;
        this.unitPrice  = unitPrice;
        this.productId  = productId;
        this.purchaseId = purchaseId;
    }

    private Item() {
        this.id         = null;
        this.quantity   = null;
        this.unitPrice  = null;
        this.productId  = null;
        this.purchaseId = null;
    }

    public static Double totalPrice(List<Item> items) {
        double totalMount = 0.0;

        for (var item : items)
            totalMount += item.unitPrice().value();

        return totalMount;
    }

    public ItemId id() {
        return id;
    }

    public ItemQuantity quantity() {
        return quantity;
    }

    public ItemUnitPrice unitPrice() {
        return unitPrice;
    }

    public ProductId productId() {
        return productId;
    }

    public PurchaseId purchaseId() {
        return purchaseId;
    }
}
