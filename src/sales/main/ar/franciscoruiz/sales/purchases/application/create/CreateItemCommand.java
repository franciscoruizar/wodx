package ar.franciscoruiz.sales.purchases.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateItemCommand implements Command {
    private final String  id;
    private final Integer quantity;
    private final String  productId;

    public CreateItemCommand(String id, Integer quantity, String productId) {
        this.id        = id;
        this.quantity  = quantity;
        this.productId = productId;
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
}
