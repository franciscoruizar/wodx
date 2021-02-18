package ar.franciscoruiz.sales.items.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateItemCommand implements Command {
    private final String  id;
    private final Integer quantity;
    private final String  productId;
    private final String  purchaseId;

    public CreateItemCommand(String id, Integer quantity, String productId, String purchaseId) {
        this.id         = id;
        this.quantity   = quantity;
        this.productId  = productId;
        this.purchaseId = purchaseId;
    }

    public String id() {
        return id;
    }

    public Integer quantity() {
        return quantity;
    }

    public String productId() {
        return productId;
    }

    public String purchaseId() {
        return purchaseId;
    }
}
