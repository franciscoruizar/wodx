package ar.franciscoruiz.accounts.purchases.application.create;

import ar.franciscoruiz.accounts.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.items.application.create.CreatePurchaseItemCommand;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.List;

@Service
public final class CreatePurchaseCommandHandler implements CommandHandler<CreatePurchaseCommand> {
    private final PurchaseCreator creator;

    public CreatePurchaseCommandHandler(PurchaseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreatePurchaseCommand command) {
        PurchaseId                      id          = new PurchaseId(command.id());
        PurchaseDescription             description = new PurchaseDescription(command.description());
        LocalDateTime                   date        = command.date();
        UserId                          userId      = new UserId(command.userId());
        List<CreatePurchaseItemCommand> items       = command.items();

        this.creator.create(id, description, date, userId, items);
    }
}
