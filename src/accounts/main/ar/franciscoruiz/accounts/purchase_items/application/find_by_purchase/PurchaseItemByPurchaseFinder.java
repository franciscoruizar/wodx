package ar.franciscoruiz.accounts.purchase_items.application.find_by_purchase;

import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainFinder;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchase_items.application.PurchaseItemResponse;
import ar.franciscoruiz.accounts.purchase_items.application.PurchaseItemsResponse;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemDomainByPurchaseFinder;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class PurchaseItemByPurchaseFinder {
    private final PurchaseItemDomainByPurchaseFinder finder;
    private final MembershipDomainFinder             membershipFinder;

    public PurchaseItemByPurchaseFinder(PurchaseItemDomainByPurchaseFinder finder, MembershipDomainFinder membershipFinder) {
        this.finder           = finder;
        this.membershipFinder = membershipFinder;
    }

    public PurchaseItemsResponse find(PurchaseId id) {
        return new PurchaseItemsResponse(
            this.finder.find(id)
                .stream()
                .map(item -> new PurchaseItemResponse(
                    item.id().value(),
                    item.purchaseId().value(),
                    item.quantity().value(),
                    findMembershipPrice(item.membershipId()),
                    item.membershipId().value()
                ))
                .collect(Collectors.toList())
        );
    }

    private Double findMembershipPrice(MembershipId membershipId) {
        return this.membershipFinder.find(membershipId).get().price().value();
    }
}
