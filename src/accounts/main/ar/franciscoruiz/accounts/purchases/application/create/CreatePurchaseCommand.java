package ar.franciscoruiz.accounts.purchases.application.create;

import ar.franciscoruiz.accounts.purchases.domain.items.application.create.CreatePurchaseItemCommand;
import ar.franciscoruiz.shared.domain.bus.command.Command;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class CreatePurchaseCommand implements Command {
    private final String                          id;
    private final String                          description;
    private final LocalDateTime                   date;
    private final String                          userId;
    private final List<CreatePurchaseItemCommand> items;

    public CreatePurchaseCommand(String id, String description, LocalDateTime date, String userId, List<CreatePurchaseItemCommand> items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.items       = items;
    }

    public CreatePurchaseCommand(String id, String description, LocalDateTime date, String userId) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.items = Collections.emptyList();
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

    public List<CreatePurchaseItemCommand> items() {
        return this.items;
    }
}
