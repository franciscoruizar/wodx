package ar.franciscoruiz.sales.purchases;

import ar.franciscoruiz.sales.SalesContextInfrastructureTestCase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PurchasesModuleInfrastructureTestCase extends SalesContextInfrastructureTestCase {
    @Autowired
    protected PurchaseRepository repository;
}
