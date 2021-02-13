package ar.franciscoruiz.sales.products;

import ar.franciscoruiz.sales.SalesContextInfrastructureTestCase;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductsModuleInfrastructureTestCase extends SalesContextInfrastructureTestCase {
    @Autowired
    protected ProductRepository repository;
}
