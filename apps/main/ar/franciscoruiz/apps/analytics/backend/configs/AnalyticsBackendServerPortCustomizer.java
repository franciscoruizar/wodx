package ar.franciscoruiz.apps.analytics.backend.configs;

import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

public final class AnalyticsBackendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    private final EnvironmentParameter param;

    public AnalyticsBackendServerPortCustomizer(EnvironmentParameter param) {
        this.param = param;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        try {
            factory.setPort(param.getInt("ANALYTICS_BACKEND_SERVER_PORT"));
        } catch (ParameterNotExist ignored) {
        }
    }
}
