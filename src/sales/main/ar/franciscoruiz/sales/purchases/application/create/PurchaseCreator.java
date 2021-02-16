package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.sales.products.domain.ProductFinder;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.sales.purchases.domain.items.ItemUnitPrice;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class PurchaseCreator {
    private final PurchaseRepository repository;
    private final ProductFinder      productFinder;

    public PurchaseCreator(PurchaseRepository repository, ProductFinder productFinder) {
        this.repository    = repository;
        this.productFinder = productFinder;
    }

    public void create(
        PurchaseId id,
        PurchaseDescription description,
        LocalDateTime date,
        UserId userId,
        CompanyId companyId,
        List<Item> items
    ) {
        Purchase purchase = new Purchase(id, description, date, userId, companyId);

        List<Item> updatedItems = items.stream().map(
            item -> new Item(
                item.id(),
                item.quantity(),
                new ItemUnitPrice(findProductPrice(item.productId()) * item.quantity().value()),
                item.productId(),
                item.purchaseId()
            )
        ).collect(Collectors.toList());

        Purchase updatedPurchase = new Purchase(purchase, updatedItems);

        this.repository.save(updatedPurchase);
    }

    public double findProductPrice(ProductId productId) {
        return this.productFinder.find(productId).price().value();
    }
}
