package ar.franciscoruiz.accounts.user_companies.infrastructure.persistence;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompany;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class MySqlUserCompanyRepository extends HibernateRepository<UserCompany> implements UserCompanyRepository {
    public MySqlUserCompanyRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, UserCompany.class);
    }

    @Override
    public void save(UserCompany entity) {
        persist(entity);
    }

    @Override
    public List<CompanyId> searchByUser(UserId userId) {
        Session session = sessionFactory.openSession();
        String  sql     = String.format("SELECT company_id FROM user_companies WHERE user_id='%s'", userId.value());
        Query   query   = session.createNativeQuery(sql);

        List<String> result = query.getResultList();

        session.close();

        return result.stream().map(CompanyId::new).collect(Collectors.toList());
    }

    @Override
    public List<UserId> searchByCompany(CompanyId companyId) {
        Session session = sessionFactory.openSession();
        String  sql     = String.format("SELECT user_id FROM user_companies WHERE company_id='%s'", companyId.value());
        Query   query   = session.createNativeQuery(sql);

        List<String> result = query.getResultList();

        session.close();

        return result.stream().map(UserId::new).collect(Collectors.toList());
    }


}
