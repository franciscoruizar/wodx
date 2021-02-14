package ar.franciscoruiz.sales.purchases.infrastructure;

import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlPurchaseRepository extends HibernateRepository<Purchase> implements PurchaseRepository {
    public MySqlPurchaseRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Purchase.class);
    }

    @Override
    public void save(Purchase entity) {
        persist(entity);
    }

    @Override
    public Optional<Purchase> search(PurchaseId id) {
        return byId(id);
    }

    @Override
    public List<Purchase> searchByUser(UserId userId) {
        Filter  filter  = new Filter(new FilterField("user_id"), FilterOperator.EQUAL, new FilterValue(userId.value()));
        Filters filters = new Filters(Collections.singletonList(filter));

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }

    @Override
    public List<Purchase> searchByCompany(CompanyId companyId) {
        Filter  filter  = new Filter(new FilterField("company_id"), FilterOperator.EQUAL, new FilterValue(companyId.value()));
        Filters filters = new Filters(Collections.singletonList(filter));

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }

    @Override
    public List<Purchase> searchByUserCompany(UserId userId, CompanyId companyId) {
        Filter filterUser    = new Filter(new FilterField("user_id"), FilterOperator.EQUAL, new FilterValue(userId.value()));
        Filter filterCompany = new Filter(new FilterField("company_id"), FilterOperator.EQUAL, new FilterValue(companyId.value()));

        List<Filter> filterList = new ArrayList<>() {{
            add(filterUser);
            add(filterCompany);
        }};

        Filters filters = new Filters(filterList);

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
