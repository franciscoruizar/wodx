package ar.franciscoruiz.sales.items.application.create;

import ar.franciscoruiz.sales.items.domain.*;
import ar.franciscoruiz.sales.products.application.ProductResponse;
import ar.franciscoruiz.sales.products.application.product.find.FindProductQuery;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

@Service
public final class ItemCreator {
    private final ItemRepository repository;
    private final QueryBus       queryBus;

    public ItemCreator(ItemRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public void create(
        ItemId id,
        ItemQuantity quantity,
        ItemUnitPrice unitPrice,
        ProductId productId,
        PurchaseId purchaseId
    ) {
        Item item = new Item(id, quantity, unitPrice, productId, purchaseId);

        this.repository.save(item);
    }

    public void create(
        ItemId id,
        ItemQuantity quantity,
        ProductId productId,
        PurchaseId purchaseId
    ) {
        ItemUnitPrice unitPrice = new ItemUnitPrice(getProductPrice(productId));

        Item item = new Item(id, quantity, unitPrice, productId, purchaseId);

        this.repository.save(item);
    }

    private Double getProductPrice(ProductId productId) {
        ProductResponse response = queryBus.ask(new FindProductQuery(productId.value()));

        return response.price();
    }
}
