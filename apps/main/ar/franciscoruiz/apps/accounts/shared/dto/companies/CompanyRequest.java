package ar.franciscoruiz.apps.accounts.shared.dto.companies;

public final class CompanyRequest {
    private String  id;
    private String  description;
    private String  mediaUrl;
    private Double  latitude;
    private Double  longitude;
    private Boolean isActive;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String description() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String mediaUrl() {
        return this.mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Double latitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double longitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
