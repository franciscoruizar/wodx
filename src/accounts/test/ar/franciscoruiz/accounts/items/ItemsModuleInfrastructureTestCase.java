package ar.franciscoruiz.accounts.items;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.items.domain.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ItemsModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected PurchaseItemRepository repository;
}
