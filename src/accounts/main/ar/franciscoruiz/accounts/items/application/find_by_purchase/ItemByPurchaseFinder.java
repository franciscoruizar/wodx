package ar.franciscoruiz.accounts.items.application.find_by_purchase;

import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainFinder;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.items.application.ItemResponse;
import ar.franciscoruiz.accounts.items.application.ItemsResponse;
import ar.franciscoruiz.accounts.items.domain.ItemDomainByPurchaseFinder;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class ItemByPurchaseFinder {
    private final ItemDomainByPurchaseFinder finder;
    private final MembershipDomainFinder     membershipFinder;

    public ItemByPurchaseFinder(ItemDomainByPurchaseFinder finder, MembershipDomainFinder membershipFinder) {
        this.finder           = finder;
        this.membershipFinder = membershipFinder;
    }

    public ItemsResponse find(PurchaseId id) {
        return new ItemsResponse(
            this.finder.find(id)
                .stream()
                .map(item -> new ItemResponse(
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
