package ar.franciscoruiz.accounts.purchases.domain.items.domain;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.application.find.FindMembershipQuery;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemResponse;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

import java.util.stream.Collectors;

@Service
public final class PurchaseItemByPurchaseFinder {
    private final PurchaseItemRepository repository;
    private final QueryBus               queryBus;

    public PurchaseItemByPurchaseFinder(PurchaseItemRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public PurchaseItemsResponse find(PurchaseId id) {
        return new PurchaseItemsResponse(
            this.repository.findByPurchaseId(id)
                .stream()
                .map(item -> new PurchaseItemResponse(
                    item.id().value(),
                    item.purchaseId().value(),
                    item.quantity().value(),
                    getPriceOfItem(item),
                    item.membershipId().value()
                )).collect(Collectors.toList())
        );
    }

    private double getPriceOfItem(PurchaseItem item) {
        MembershipResponse membership = this.queryBus.ask(new FindMembershipQuery(item.membershipId().value()));

        return membership.price() * item.quantity().value();
    }
}
