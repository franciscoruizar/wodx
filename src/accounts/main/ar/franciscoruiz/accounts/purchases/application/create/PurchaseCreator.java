package ar.franciscoruiz.accounts.purchases.application.create;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.accounts.purchases.domain.items.application.create.CreatePurchaseItemCommand;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemCreator;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemId;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemQuantity;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.List;

@Service
public final class PurchaseCreator {
    private final PurchaseRepository  repository;
    private final PurchaseItemCreator itemCreator;

    public PurchaseCreator(PurchaseRepository repository, PurchaseItemCreator itemCreator) {
        this.repository  = repository;
        this.itemCreator = itemCreator;
    }

    public void create(
        PurchaseId id,
        PurchaseDescription description,
        LocalDateTime date,
        UserId userId,
        List<CreatePurchaseItemCommand> items
    ) {
        Purchase purchase = new Purchase(id.value(), description.value(), date, userId.value());

        this.repository.save(purchase);

        items.forEach(item -> this.itemCreator.create(
            new PurchaseItemId(item.id()),
            new PurchaseId(item.purchaseId()),
            new PurchaseItemQuantity(item.quantity()),
            new MembershipId(item.membershipId())
        ));
    }
}
