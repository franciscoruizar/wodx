package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    void save(Company company);

    Optional<Company> search(CompanyId id);

    List<Company> findAll();

    List<Company> matching(Criteria criteria);
}
