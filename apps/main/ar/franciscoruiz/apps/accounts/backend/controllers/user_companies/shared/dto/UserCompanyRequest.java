package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies.shared.dto;

public final class UserCompanyRequest {
    private String id;
    private String userId;
    private String companyId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String userId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String companyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
