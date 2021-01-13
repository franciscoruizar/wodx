package ar.franciscoruiz.accounts.companies.application.create;

import ar.franciscoruiz.accounts.companies.domain.CompanyDescription;
import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCompanyCommandHandler implements CommandHandler<CreateCompanyCommand> {
    private final CompanyCreator creator;

    public CreateCompanyCommandHandler(CompanyCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCompanyCommand command) {
        CompanyId          id          = new CompanyId(command.id());
        CompanyDescription description = new CompanyDescription(command.description());

        this.creator.create(id, description);
    }
}
