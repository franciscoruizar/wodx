package ar.franciscoruiz.sales.products.application.material_product.find;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductNotExist;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MaterialProductFinder {
    private final MaterialProductRepository repository;

    public MaterialProductFinder(MaterialProductRepository repository) {
        this.repository = repository;
    }

    public MaterialProductResponse find(ProductId id) {
        return this.repository.search(id)
            .map(MaterialProductResponse::fromAggregate)
            .orElseThrow(() -> new ProductNotExist(id));
    }
}
