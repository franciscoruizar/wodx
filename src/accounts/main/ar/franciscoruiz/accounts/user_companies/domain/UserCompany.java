package ar.franciscoruiz.accounts.user_companies.domain;

public final class UserCompany {
    private final String id;
    private final String userId;
    private final String companyId;

    public UserCompany(String id, String userId, String companyId) {
        this.id        = id;
        this.userId    = userId;
        this.companyId = companyId;
    }

    public UserCompany() {
        this.id        = null;
        this.userId    = null;
        this.companyId = null;
    }

    public String id() {
        return this.id;
    }

    public String userId() {
        return this.userId;
    }

    public String companyId() {
        return this.companyId;
    }
}
