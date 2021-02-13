package ar.franciscoruiz.sales.products.application.material_product.create;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductWeight;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class CreateMaterialProductCommandHandler implements CommandHandler<CreateMaterialProductCommand> {
    private final MaterialProductCreator creator;

    public CreateMaterialProductCommandHandler(MaterialProductCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateMaterialProductCommand command) {
        ProductId             id          = new ProductId(command.id());
        ProductTitle          title       = new ProductTitle(command.title());
        ProductDescription    description = new ProductDescription(command.description());
        ProductPrice          price       = new ProductPrice(command.price());
        ProductIsActive       isActive    = new ProductIsActive(command.isActive());
        CompanyId             companyId   = new CompanyId(command.companyId());
        MaterialProductWeight weight      = new MaterialProductWeight(command.weight());

        this.creator.create(
            id,
            title,
            description,
            price,
            isActive,
            companyId,
            weight
        );
    }
}
