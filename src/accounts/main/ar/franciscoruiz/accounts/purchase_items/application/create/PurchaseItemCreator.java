package ar.franciscoruiz.accounts.purchase_items.application.create;

import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainFinder;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItem;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemId;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemQuantity;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemRepository;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PurchaseItemCreator {
    private final PurchaseItemRepository repository;
    private final MembershipDomainFinder finder;

    public PurchaseItemCreator(PurchaseItemRepository repository, MembershipRepository membershipRepository) {
        this.repository = repository;
        this.finder     = new MembershipDomainFinder(membershipRepository);
    }

    public void create(
        PurchaseItemId id,
        PurchaseId purchaseId,
        PurchaseItemQuantity quantity,
        MembershipId membershipId
    ) {
        ensureMembership(membershipId);

        PurchaseItem item = new PurchaseItem(id, purchaseId, quantity, membershipId);

        this.repository.save(item);
    }

    private void ensureMembership(MembershipId membershipId) {
        this.finder.find(membershipId);
    }
}
