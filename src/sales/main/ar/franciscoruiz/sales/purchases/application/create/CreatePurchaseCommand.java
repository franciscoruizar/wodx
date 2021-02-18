package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.sales.items.application.create.CreateItemCommand;
import ar.franciscoruiz.shared.domain.bus.command.Command;

import java.time.LocalDateTime;
import java.util.List;

public final class CreatePurchaseCommand implements Command {
    private final String                  id;
    private final String                  description;
    private final LocalDateTime           date;
    private final String                  userId;
    private final String                  companyId;
    private final List<CreateItemCommand> items;

    public CreatePurchaseCommand(String id, String description, LocalDateTime date, String userId, String companyId, List<CreateItemCommand> items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.items       = items;
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

    public List<CreateItemCommand> items() {
        return items;
    }
}
