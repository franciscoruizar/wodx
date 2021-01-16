package ar.franciscoruiz.accounts.companies.domain;

public final class Company {
    private final CompanyId          id;
    private final CompanyDescription description;
    private final CompanyMediaUrl    mediaUrl;
    private final CompanyLatitude    latitude;
    private final CompanyLongitude   longitude;
    private final CompanyIsActive    isActive;

    public Company(
        CompanyId id,
        CompanyDescription description,
        CompanyMediaUrl mediaUrl,
        CompanyLatitude latitude,
        CompanyLongitude longitude,
        CompanyIsActive isActive
    ) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
        this.latitude    = latitude;
        this.longitude   = longitude;
        this.isActive    = isActive;
    }

    public Company() {
        this.id          = null;
        this.description = null;
        this.mediaUrl    = null;
        this.latitude    = null;
        this.longitude   = null;
        this.isActive    = null;
    }

    public CompanyId id() {
        return this.id;
    }

    public CompanyDescription description() {
        return this.description;
    }

    public CompanyMediaUrl mediaUrl() {
        return this.mediaUrl;
    }

    public CompanyLatitude latitude() {
        return this.latitude;
    }

    public CompanyLongitude longitude() {
        return this.longitude;
    }

    public CompanyIsActive isActive() {
        return this.isActive;
    }
}
