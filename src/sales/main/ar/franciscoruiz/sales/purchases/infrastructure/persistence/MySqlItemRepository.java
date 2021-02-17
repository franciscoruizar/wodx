package ar.franciscoruiz.sales.purchases.infrastructure.persistence;

import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.sales.purchases.domain.items.ItemRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.List;

@Service
public final class MySqlItemRepository extends HibernateRepository<Item> implements ItemRepository {
    public MySqlItemRepository(@Qualifier("sales-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Item.class);
    }

    @Override
    public void save(Item item) {
        persist(item);
    }

    @Override
    public List<Item> findByPurchase(PurchaseId id) {
        Filter  filter  = new Filter(new FilterField("purchaseId"), FilterOperator.EQUAL, new FilterValue(id.value()));
        Filters filters = new Filters(Collections.singletonList(filter));

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
