package ar.franciscoruiz.sales.products;

import ar.franciscoruiz.sales.SalesContextInfrastructureTestCase;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductRepository;
import ar.franciscoruiz.sales.products.domain.membership.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductsModuleInfrastructureTestCase extends SalesContextInfrastructureTestCase {
    @Autowired
    protected MaterialProductRepository materialProductRepository;

    @Autowired
    protected MembershipRepository membershipRepository;
}
