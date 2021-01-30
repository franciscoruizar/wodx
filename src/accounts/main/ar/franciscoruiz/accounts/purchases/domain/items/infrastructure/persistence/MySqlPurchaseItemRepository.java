package ar.franciscoruiz.accounts.purchases.domain.items.infrastructure.persistence;

import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItem;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemId;
import ar.franciscoruiz.accounts.purchases.domain.items.domain.PurchaseItemRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlPurchaseItemRepository extends HibernateRepository<PurchaseItem> implements PurchaseItemRepository {
    public MySqlPurchaseItemRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, PurchaseItem.class);
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
