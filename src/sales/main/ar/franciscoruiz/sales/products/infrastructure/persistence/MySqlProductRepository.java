package ar.franciscoruiz.sales.products.infrastructure.persistence;

import ar.franciscoruiz.sales.products.domain.Product;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
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
public final class MySqlProductRepository extends HibernateRepository<Product> implements ProductRepository {
    public MySqlProductRepository(@Qualifier("purchases-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Product.class);
    }

    @Override
    public void save(Product product) {
        persist(product);
    }

    @Override
    public Optional<Product> search(ProductId id) {
        return byId(id);
    }

    @Override
    public List<Product> searchByCompany(CompanyId companyId) {
        Filter  filter  = new Filter(new FilterField("company_id"), FilterOperator.EQUAL, new FilterValue(companyId.value()));
        Filters filters = new Filters(Collections.singletonList(filter));

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
