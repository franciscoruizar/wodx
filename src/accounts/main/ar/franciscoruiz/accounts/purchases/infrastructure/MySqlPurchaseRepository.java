package ar.franciscoruiz.accounts.purchases.infrastructure;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Purchase> searchByCompany(CompanyId companyId) {
        try {
            super.openSession();

            String sql   = String.format("SELECT id, description, date, user_id, company_id FROM purchases WHERE company_id = '%s'", companyId.value());
            Query  query = super.session().createNativeQuery(sql);

            List<Object[]> result = query.getResultList();

            return result.stream().map(objects -> new Purchase(
                new PurchaseId((String) objects[0]),
                new PurchaseDescription((String) objects[1]),
                Date.valueOf((String) objects[2]).toLocalDate().atStartOfDay(),
                new UserId((String) objects[3]),
                new CompanyId((String) objects[4])
            )).collect(Collectors.toList());

        } catch (Exception e) {
            logger.warning(e.getMessage());
            e.printStackTrace();
        } finally {
            super.closeSession();
        }

        return Collections.emptyList();
    }
}
