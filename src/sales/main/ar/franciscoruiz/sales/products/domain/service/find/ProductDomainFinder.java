package ar.franciscoruiz.sales.products.domain.service.find;

import ar.franciscoruiz.sales.products.domain.Product;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductNotExist;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ProductDomainFinder {
    private final ProductRepository repository;

    public ProductDomainFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public Product find(ProductId id) {
        return this.repository.search(id)
            .orElseThrow(() -> new ProductNotExist(id));
    }
}
