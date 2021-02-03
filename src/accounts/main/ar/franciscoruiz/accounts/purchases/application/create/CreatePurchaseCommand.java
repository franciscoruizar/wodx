package ar.franciscoruiz.accounts.purchases.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

import java.time.LocalDateTime;

public final class CreatePurchaseCommand implements Command {
    private final String        id;
    private final String        description;
    private final LocalDateTime date;
    private final String        userId;
    private final String        companyId;

    public CreatePurchaseCommand(String id, String description, LocalDateTime date, String userId, String companyId) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
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

    public String companyId() {
        return companyId;
    }
}
