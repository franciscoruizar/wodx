package ar.franciscoruiz.sales.products.infrastructure.persistence;

import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductRepository;
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
public final class MySqlMaterialProductRepository extends HibernateRepository<MaterialProduct> implements MaterialProductRepository {
    public MySqlMaterialProductRepository(@Qualifier("sales-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, MaterialProduct.class);
    }

    @Override
    public void save(MaterialProduct product) {
        persist(product);
    }

    @Override
    public Optional<MaterialProduct> search(ProductId id) {
        return byId(id);
    }

    @Override
    public List<MaterialProduct> searchByCompany(CompanyId companyId) {
        Filter   filter   = new Filter(new FilterField("companyId"), FilterOperator.EQUAL, new FilterValue(companyId.value()));
        Filters  filters  = new Filters(Collections.singletonList(filter));
        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
