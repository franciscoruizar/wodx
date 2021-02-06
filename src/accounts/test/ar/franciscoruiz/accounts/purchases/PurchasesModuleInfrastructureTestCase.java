package ar.franciscoruiz.accounts.purchases;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PurchasesModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected PurchaseRepository repository;
}
