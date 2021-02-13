package ar.franciscoruiz.sales.items.infrastructure.persistence;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemId;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlItemRepository extends HibernateRepository<Item> implements ItemRepository {
    public MySqlItemRepository(@Qualifier("sales-session_factory") SessionFactory sessionFactory) {
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
        Filter   filter   = new Filter(new FilterField("purchase_id"), FilterOperator.EQUAL, new FilterValue(id.value()));
        Filters  filters  = new Filters(Collections.singletonList(filter));
        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
