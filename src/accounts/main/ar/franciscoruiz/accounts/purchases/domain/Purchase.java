package ar.franciscoruiz.accounts.purchases.domain;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;

public final class Purchase {
    private final PurchaseId          id;
    private final PurchaseDescription description;
    private final LocalDateTime       date;
    private final UserId              userId;
    private final CompanyId           companyId;

    public Purchase(PurchaseId id, PurchaseDescription description, LocalDateTime date, UserId userId, CompanyId companyId) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
    }

    private Purchase() {
        this.id          = null;
        this.description = null;
        this.date        = null;
        this.userId      = null;
        this.companyId   = null;
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
}
