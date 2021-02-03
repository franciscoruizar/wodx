package ar.franciscoruiz.accounts.purchases.infrastructure;

import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlPurchaseRepository extends HibernateRepository<Purchase> implements PurchaseRepository {
    public MySqlPurchaseRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, Purchase.class, "accounts");
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
    public List<Purchase> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
