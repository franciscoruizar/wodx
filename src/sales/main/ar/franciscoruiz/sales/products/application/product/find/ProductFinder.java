package ar.franciscoruiz.sales.products.application.product.find;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductNotExist;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ProductFinder {
    private final ProductRepository repository;

    public ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public MaterialProductResponse find(ProductId id) {
        return this.repository.search(id)
            .map(product -> MaterialProductResponse.fromAggregate((MaterialProduct) product))
            .orElseThrow(() -> new ProductNotExist(id));
    }
}
