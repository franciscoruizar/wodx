package ar.franciscoruiz.accounts.companies.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateCompanyCommand implements Command {
    private final String  id;
    private final String  description;
    private final String  mediaUrl;
    private final Double  latitude;
    private final Double  longitude;
    private final Boolean isActive;

    public CreateCompanyCommand(String id, String description, String mediaUrl, Double latitude, Double longitude, Boolean isActive) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
        this.latitude    = latitude;
        this.longitude   = longitude;
        this.isActive    = isActive;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String mediaUrl() {
        return this.mediaUrl;
    }

    public Double latitude() {
        return this.latitude;
    }

    public Double longitude() {
        return this.longitude;
    }

    public Boolean isActive() {
        return this.isActive;
    }
}
