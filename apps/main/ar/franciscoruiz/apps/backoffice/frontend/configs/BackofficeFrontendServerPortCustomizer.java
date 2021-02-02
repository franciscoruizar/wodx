package ar.franciscoruiz.apps.backoffice.frontend.configs;

import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class BackofficeFrontendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    private final EnvironmentParameter param;

    public BackofficeFrontendServerPortCustomizer(EnvironmentParameter param) {
        this.param = param;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        try {
            factory.setPort(param.getInt("BACKOFFICE_FRONTEND_SERVER_PORT"));
        } catch (ParameterNotExist parameterNotExist) {
            parameterNotExist.printStackTrace();
        }
    }
}
