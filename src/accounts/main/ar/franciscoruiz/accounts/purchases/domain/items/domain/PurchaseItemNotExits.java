package ar.franciscoruiz.accounts.purchases.domain.items.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class PurchaseItemNotExits extends DomainError {
    public PurchaseItemNotExits(PurchaseItemId id) {
        super("purchase_item_not_exist", String.format("The purchase item <%s> doesn't exist", id.value()));
    }
}
