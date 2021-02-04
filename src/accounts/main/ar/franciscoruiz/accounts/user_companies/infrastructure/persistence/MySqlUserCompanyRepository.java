package ar.franciscoruiz.accounts.user_companies.infrastructure.persistence;

import ar.franciscoruiz.accounts.user_companies.domain.UserCompany;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

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
    public List<UserCompany> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
