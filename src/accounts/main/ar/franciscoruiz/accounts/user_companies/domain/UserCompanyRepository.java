package ar.franciscoruiz.accounts.user_companies.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;

public interface UserCompanyRepository {
    void save(UserCompany entity);

    List<UserCompany> matching(Criteria criteria);
}
