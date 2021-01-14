package ar.franciscoruiz.accounts.companies.application;

import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class CompanyResponse implements Response {
    private final String  id;
    private final String  description;
    private final String  mediaUrl;
    private final Double  latitude;
    private final Double  longitude;
    private final Boolean isActive;

    public CompanyResponse(
        String id,
        String description,
        String mediaUrl,
        Double latitude,
        Double longitude,
        Boolean isActive
    ) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
        this.latitude    = latitude;
        this.longitude   = longitude;
        this.isActive    = isActive;
    }

    public static CompanyResponse fromAggregate(Company entity) {
        return new CompanyResponse(
            entity.id().value(),
            entity.description().value(),
            entity.mediaUrl().value(),
            entity.latitude().value(),
            entity.longitude().value(),
            entity.isActive().value()
        );
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
