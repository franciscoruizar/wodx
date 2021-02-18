package ar.franciscoruiz.sales.items.application.create;

import ar.franciscoruiz.sales.items.domain.ItemId;
import ar.franciscoruiz.sales.items.domain.ItemQuantity;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateItemCommandHandler implements CommandHandler<CreateItemCommand> {

    @Override
    public void handle(CreateItemCommand command) {
        ItemId       id         = new ItemId(command.id());
        ItemQuantity quantity   = new ItemQuantity(command.quantity());
        ProductId    productId  = new ProductId(command.productId());
        PurchaseId   purchaseId = new PurchaseId(command.purchaseId());
    }
}
