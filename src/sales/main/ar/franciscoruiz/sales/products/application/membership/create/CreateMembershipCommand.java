package ar.franciscoruiz.sales.products.application.membership.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateMembershipCommand implements Command {
    private final String  id;
    private final String  title;
    private final String  description;
    private final Double  price;
    private final Boolean isActive;
    private final String  companyId;
    private final Integer numberDaysEnabled;

    public CreateMembershipCommand(
        String id,
        String title,
        String description,
        Double price,
        Boolean isActive,
        String companyId,
        Integer numberDaysEnabled
    ) {
        this.id                = id;
        this.title             = title;
        this.description       = description;
        this.price             = price;
        this.isActive          = isActive;
        this.companyId         = companyId;
        this.numberDaysEnabled = numberDaysEnabled;
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

    public Integer numberDaysEnabled() {
        return numberDaysEnabled;
    }
}
