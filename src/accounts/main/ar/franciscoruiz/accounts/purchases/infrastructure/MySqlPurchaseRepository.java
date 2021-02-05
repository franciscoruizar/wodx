package ar.franciscoruiz.accounts.purchases.infrastructure;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseDescription;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Purchase> searchByCompany(CompanyId companyId) {
        Session session = sessionFactory.openSession();

        String sql   = String.format("SELECT id, description, date, user_id, company_id FROM purchases WHERE company_id = '%s'", companyId.value());
        Query  query = session.createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        session.close();

        return result.stream().map(objects -> new Purchase(
            new PurchaseId((String) objects[0]),
            new PurchaseDescription((String) objects[1]),
            Date.valueOf((String) objects[2]).toLocalDate().atStartOfDay(),
            new UserId((String) objects[3]),
            new CompanyId((String) objects[4])
        )).collect(Collectors.toList());
    }
}
