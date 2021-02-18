package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.items.domain.services.create.ItemDomainCreator;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.List;

@Service
public final class PurchaseCreator {
    private final PurchaseRepository repository;
    private final ItemDomainCreator  creator;

    public PurchaseCreator(PurchaseRepository repository, ItemRepository itemRepository, ProductRepository productRepository) {
        this.repository = repository;
        this.creator    = new ItemDomainCreator(itemRepository, productRepository);
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

        repository.save(purchase);

        items.forEach(item -> creator.create(
            item.id(),
            item.quantity(),
            item.productId(),
            item.purchaseId()
        ));
    }
}
