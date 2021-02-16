package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ProductFinder {
    private final ProductRepository repository;

    public ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public Product find(ProductId id) {
        return this.repository.search(id)
            .orElseThrow(() -> new ProductNotExist(id));
    }
}
