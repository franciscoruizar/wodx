package ar.franciscoruiz.accounts.purchases.domain;

import java.time.LocalDateTime;

public final class Purchase {
    private final String        id;
    private final String        description;
    private final LocalDateTime date;
    private final String        userId;

    public Purchase(String id, String description, LocalDateTime date, String userId) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public LocalDateTime date() {
        return this.date;
    }

    public String userId() {
        return this.userId;
    }
}
