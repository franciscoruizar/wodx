package ar.franciscoruiz.sales.products.application.material_product.find;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindMaterialProductQueryHandler implements QueryHandler<FindMaterialProductQuery, MaterialProductResponse> {
    private final MaterialProductFinder finder;

    public FindMaterialProductQueryHandler(MaterialProductFinder finder) {
        this.finder = finder;
    }

    @Override
    public MaterialProductResponse handle(FindMaterialProductQuery query) {
        ProductId id = new ProductId(query.id());

        return this.finder.find(id);
    }
}
