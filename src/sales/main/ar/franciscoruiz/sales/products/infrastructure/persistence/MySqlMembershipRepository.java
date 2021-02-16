package ar.franciscoruiz.sales.products.infrastructure.persistence;

import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.sales.products.domain.membership.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlMembershipRepository extends HibernateRepository<Membership> implements MembershipRepository {
    public MySqlMembershipRepository(@Qualifier("sales-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Membership.class);
    }

    @Override
    public void save(Membership membership) {
        persist(membership);
    }

    @Override
    public Optional<Membership> search(ProductId id) {
        return byId(id);
    }

    @Override
    public List<Membership> searchByCompany(CompanyId companyId) {
        Filter   filter   = new Filter(new FilterField("companyId"), FilterOperator.EQUAL, new FilterValue(companyId.value()));
        Filters  filters  = new Filters(Collections.singletonList(filter));
        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
