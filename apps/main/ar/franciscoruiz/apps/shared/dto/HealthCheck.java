package ar.franciscoruiz.apps.shared.dto;

public final class HealthCheck {
    private final String application;
    private final String status;

    public HealthCheck(String application, String status) {
        this.application = application;
        this.status      = status;
    }

    public HealthCheck() {
        this.application = null;
        this.status      = null;
    }

    public String getApplication() {
        return application;
    }

    public String getStatus() {
        return status;
    }
}
