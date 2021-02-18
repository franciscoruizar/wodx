package ar.franciscoruiz.sales.items.domain.services.create;

import ar.franciscoruiz.sales.items.domain.*;
import ar.franciscoruiz.sales.products.domain.Product;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.products.domain.service.find.ProductDomainFinder;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ItemDomainCreator {
    private final ItemRepository      repository;
    private final ProductDomainFinder productFinder;

    public ItemDomainCreator(ItemRepository repository, ProductRepository productRepository) {
        this.repository    = repository;
        this.productFinder = new ProductDomainFinder(productRepository);
    }

    public void create(
        ItemId id,
        ItemQuantity quantity,
        ProductId productId,
        PurchaseId purchaseId
    ) {
        Product product = productFinder.find(productId);

        ItemUnitPrice unitPrice = new ItemUnitPrice(product.price().value());

        Item item = new Item(id, quantity, unitPrice, productId, purchaseId);

        repository.save(item);
    }
}
