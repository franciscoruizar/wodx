package ar.franciscoruiz.accounts.items.application.create;

import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainFinder;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.accounts.items.domain.Item;
import ar.franciscoruiz.accounts.items.domain.ItemId;
import ar.franciscoruiz.accounts.items.domain.ItemQuantity;
import ar.franciscoruiz.accounts.items.domain.PurchaseItemRepository;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ItemCreator {
    private final PurchaseItemRepository repository;
    private final MembershipDomainFinder finder;

    public ItemCreator(PurchaseItemRepository repository, MembershipRepository membershipRepository) {
        this.repository = repository;
        this.finder     = new MembershipDomainFinder(membershipRepository);
    }

    public void create(
        ItemId id,
        PurchaseId purchaseId,
        ItemQuantity quantity,
        MembershipId membershipId
    ) {
        ensureMembership(membershipId);

        Item item = new Item(id, purchaseId, quantity, membershipId);

        this.repository.save(item);
    }

    private void ensureMembership(MembershipId membershipId) {
        this.finder.find(membershipId);
    }
}
