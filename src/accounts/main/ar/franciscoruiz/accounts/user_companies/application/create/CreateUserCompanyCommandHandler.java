package ar.franciscoruiz.accounts.user_companies.application.create;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class CreateUserCompanyCommandHandler implements CommandHandler<CreateUserCompanyCommand> {
    private final UserCompanyCreator creator;

    public CreateUserCompanyCommandHandler(UserCompanyCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateUserCompanyCommand command) {
        UserCompanyId id        = new UserCompanyId(command.id());
        UserId        userId    = new UserId(command.userId());
        CompanyId     companyId = new CompanyId(command.companyId());

        this.creator.create(id, userId, companyId);
    }
}
