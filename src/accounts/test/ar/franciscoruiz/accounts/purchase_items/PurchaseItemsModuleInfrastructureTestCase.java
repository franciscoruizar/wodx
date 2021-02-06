package ar.franciscoruiz.accounts.purchase_items;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PurchaseItemsModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected PurchaseItemRepository repository;
}
