package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class Purchase {
    private final PurchaseId          id;
    private final PurchaseDescription description;
    private final LocalDateTime       date;
    private final UserId              userId;
    private final CompanyId           companyId;
    private final List<Item>          items;

    public Purchase(PurchaseId id, PurchaseDescription description, LocalDateTime date, UserId userId, CompanyId companyId, List<Item> items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.items       = items;
    }

    public Purchase(PurchaseId id, PurchaseDescription description, LocalDateTime date, UserId userId, CompanyId companyId) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.items       = Collections.emptyList();
    }

    public Purchase(Purchase purchase, List<Item> items) {
        this.id          = purchase.id();
        this.description = purchase.description();
        this.date        = purchase.date();
        this.userId      = purchase.userId();
        this.companyId   = purchase.companyId();
        this.items       = items;
    }

    private Purchase() {
        this.id          = null;
        this.description = null;
        this.date        = null;
        this.userId      = null;
        this.companyId   = null;
        this.items       = null;
    }

    public PurchaseId id() {
        return id;
    }

    public PurchaseDescription description() {
        return description;
    }

    public LocalDateTime date() {
        return date;
    }

    public UserId userId() {
        return userId;
    }

    public CompanyId companyId() {
        return companyId;
    }

    public List<Item> items() {
        return items;
    }
}
