package ar.franciscoruiz.accounts.user_companies.domain;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.List;

public interface UserCompanyRepository {
    void save(UserCompany entity);

    List<CompanyId> searchByUser(UserId userId);

    List<UserId> searchByCompany(CompanyId companyId);
}
