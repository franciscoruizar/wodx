package ar.franciscoruiz.sales.purchases.application.find;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseNotExits;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.sales.purchases.domain.items.ItemRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.List;

@Service
public final class PurchaseFinder {
    private final PurchaseRepository repository;
    private final ItemRepository     itemRepository;

    public PurchaseFinder(PurchaseRepository repository, ItemRepository itemRepository) {
        this.repository     = repository;
        this.itemRepository = itemRepository;
    }

    public PurchaseResponse find(PurchaseId id) {
        Purchase   purchase = this.repository.search(id).orElseThrow(() -> new PurchaseNotExits(id));
        List<Item> items    = this.itemRepository.findByPurchase(id);

        double totalPrice = 0.0;

        for (var item : items)
            totalPrice += item.unitPrice().value();

        return PurchaseResponse.fromAggregate(purchase, totalPrice, items);
    }
}
