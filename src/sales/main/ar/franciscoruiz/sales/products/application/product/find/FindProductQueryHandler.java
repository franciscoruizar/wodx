package ar.franciscoruiz.sales.products.application.product.find;
import ar.franciscoruiz.sales.products.application.ProductResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindProductQueryHandler implements QueryHandler<FindProductQuery, ProductResponse> {
    private final ProductFinder finder;

    public FindProductQueryHandler(ProductFinder finder) {
        this.finder = finder;
    }

    @Override
    public ProductResponse handle(FindProductQuery query) {
        ProductId id = new ProductId(query.id());

        return this.finder.find(id);
    }
}
