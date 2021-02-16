package ar.franciscoruiz.sales.purchases.domain.items;

import ar.franciscoruiz.shared.domain.DomainError;

public final class ItemNotExits extends DomainError {
    public ItemNotExits(ItemId id) {
        super("purchase_item_not_exist", String.format("The purchase item <%s> doesn't exist", id.value()));
    }
}
