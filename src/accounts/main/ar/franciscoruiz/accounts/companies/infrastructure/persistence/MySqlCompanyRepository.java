package ar.franciscoruiz.accounts.companies.infrastructure.persistence;

import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlCompanyRepository extends HibernateRepository<Company> implements CompanyRepository {
    public MySqlCompanyRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Company.class);
    }

    @Override
    public void save(Company entity) {
        persist(entity);
    }

    @Override
    public Optional<Company> search(CompanyId id) {
        return byId(id);
    }

    @Override
    public List<Company> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
