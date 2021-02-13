package ar.franciscoruiz.accounts.companies.application.create;

import ar.franciscoruiz.accounts.companies.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

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
        CompanyMediaUrl    mediaUrl    = new CompanyMediaUrl(command.mediaUrl());
        CompanyLatitude    latitude    = new CompanyLatitude(command.latitude());
        CompanyLongitude   longitude   = new CompanyLongitude(command.longitude());
        CompanyIsActive    isActive    = new CompanyIsActive(command.isActive());

        this.creator.create(id, description, mediaUrl, latitude, longitude, isActive);
    }
}
