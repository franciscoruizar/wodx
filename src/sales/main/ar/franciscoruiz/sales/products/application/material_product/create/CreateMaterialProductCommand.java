package ar.franciscoruiz.sales.products.application.material_product.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateMaterialProductCommand implements Command {
    private final String  id;
    private final String  title;
    private final String  description;
    private final Double  price;
    private final Boolean isActive;
    private final String  companyId;
    private final Integer weight;

    public CreateMaterialProductCommand(
        String id,
        String title,
        String description,
        Double price,
        Boolean isActive,
        String companyId,
        Integer weight
    ) {
        this.id          = id;
        this.title       = title;
        this.description = description;
        this.price       = price;
        this.isActive    = isActive;
        this.companyId   = companyId;
        this.weight      = weight;
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public Double price() {
        return price;
    }

    public Boolean isActive() {
        return isActive;
    }

    public String companyId() {
        return companyId;
    }

    public Integer weight() {
        return weight;
    }
}
