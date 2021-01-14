package ar.franciscoruiz.accounts.user_companies.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateUserCompanyCommand implements Command {
    private final String id;
    private final String userId;
    private final String companyId;

    public CreateUserCompanyCommand(String id, String userId, String companyId) {
        this.id        = id;
        this.userId    = userId;
        this.companyId = companyId;
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
