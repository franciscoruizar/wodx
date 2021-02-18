package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemId;
import ar.franciscoruiz.sales.items.domain.ItemQuantity;
import ar.franciscoruiz.sales.items.domain.ItemUnitPrice;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class CreatePurchaseCommandHandler implements CommandHandler<CreatePurchaseCommand> {
    private final PurchaseCreator creator;

    public CreatePurchaseCommandHandler(PurchaseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreatePurchaseCommand command) {
        PurchaseId          id          = new PurchaseId(command.id());
        PurchaseDescription description = new PurchaseDescription(command.description());
        LocalDateTime       date        = command.date();
        UserId              userId      = new UserId(command.userId());
        CompanyId           companyId   = new CompanyId(command.companyId());
        List<Item> items = command.items().stream().map(item -> new Item(
            new ItemId(item.id()),
            new ItemQuantity(item.quantity()),
            new ItemUnitPrice(0.0),
            new ProductId(item.productId()),
            id
        )).collect(Collectors.toList());

        this.creator.create(id, description, date, userId, companyId, items);
    }
}
