package ar.franciscoruiz.apps.workouts.backend.configs;

import ar.franciscoruiz.apps.shared.middleware.BasicHttpAuthMiddleware;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkoutsBackendServerConfiguration {
    private final CommandBus bus;

    public WorkoutsBackendServerConfiguration(CommandBus bus) {
        this.bus = bus;
    }

    @Bean
    public FilterRegistrationBean<BasicHttpAuthMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<BasicHttpAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new BasicHttpAuthMiddleware(bus));
        registrationBean.addUrlPatterns("/exercises");

        return registrationBean;
    }
}
