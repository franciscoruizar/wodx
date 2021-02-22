package ar.franciscoruiz.apps.shared.dto;

public final class HealthCheck {
    private String application;
    private String status;

    public HealthCheck(String application, String status) {
        this.application = application;
        this.status      = status;
    }

    public String application() {
        return application;
    }

    public String status() {
        return status;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
