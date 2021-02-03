package ar.franciscoruiz.accounts.purchase_items.infrastructure.persistence;

import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItem;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemId;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemRepository;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlPurchaseItemRepository extends HibernateRepository<PurchaseItem> implements PurchaseItemRepository {
    public MySqlPurchaseItemRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, PurchaseItem.class, "accounts");
    }

    @Override
    public void save(PurchaseItem entity) {
        persist(entity);
    }

    @Override
    public Optional<PurchaseItem> search(PurchaseItemId id) {
        return byId(id);
    }

    @Override
    public List<PurchaseItem> findByPurchaseId(PurchaseId id) {
        Filters filters = Filters.fromValues(new ArrayList<>() {{
            new Filter(new FilterField("purchase_id"), FilterOperator.EQUAL, new FilterValue(id.value()));
        }});

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
