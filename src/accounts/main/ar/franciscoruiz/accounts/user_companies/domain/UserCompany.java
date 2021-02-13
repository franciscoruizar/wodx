package ar.franciscoruiz.accounts.user_companies.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.Objects;

public final class UserCompany {
    private final UserCompanyId id;
    private final UserId        userId;
    private final CompanyId     companyId;

    public UserCompany(UserCompanyId id, UserId userId, CompanyId companyId) {
        this.id        = id;
        this.userId    = userId;
        this.companyId = companyId;
    }

    public UserCompany() {
        this.id        = null;
        this.userId    = null;
        this.companyId = null;
    }

    public UserCompanyId id() {
        return id;
    }

    public UserId userId() {
        return userId;
    }

    public CompanyId companyId() {
        return companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCompany that = (UserCompany) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, companyId);
    }
}
