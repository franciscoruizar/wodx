package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class PurchaseNotExits extends DomainError {
    public PurchaseNotExits(PurchaseId id) {
        super("purchase_not_exist", String.format("The purchase <%s> doesn't exist", id.value()));
    }
}
