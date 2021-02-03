package ar.franciscoruiz.accounts.companies.infrastructure.persistence;

import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlCompanyRepository extends HibernateRepository<Company> implements CompanyRepository {
    public MySqlCompanyRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, Company.class, "accounts");
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
    public List<Company> findAll() {
        return super.all();
    }

    @Override
    public List<Company> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
