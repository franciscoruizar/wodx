package ar.franciscoruiz.accounts.items.infrastructure.persistence;

import ar.franciscoruiz.accounts.items.domain.Item;
import ar.franciscoruiz.accounts.items.domain.ItemId;
import ar.franciscoruiz.accounts.items.domain.PurchaseItemRepository;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlItemRepository extends HibernateRepository<Item> implements PurchaseItemRepository {
    public MySqlItemRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Item.class);
    }

    @Override
    public void save(Item entity) {
        persist(entity);
    }

    @Override
    public Optional<Item> search(ItemId id) {
        return byId(id);
    }

    @Override
    public List<Item> findByPurchaseId(PurchaseId id) {
        Filters filters = Filters.fromValues(new ArrayList<>() {{
            new Filter(new FilterField("purchase_id"), FilterOperator.EQUAL, new FilterValue(id.value()));
        }});

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
