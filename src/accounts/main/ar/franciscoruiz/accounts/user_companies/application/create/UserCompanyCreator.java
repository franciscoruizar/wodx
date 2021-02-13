package ar.franciscoruiz.accounts.user_companies.application.create;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompany;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyId;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserCompanyCreator {
    private final UserCompanyRepository repository;

    public UserCompanyCreator(UserCompanyRepository repository) {
        this.repository = repository;
    }

    public void create(UserCompanyId id, UserId userId, CompanyId companyId) {
        UserCompany userCompany = new UserCompany(id, userId, companyId);

        this.repository.save(userCompany);
    }
}
