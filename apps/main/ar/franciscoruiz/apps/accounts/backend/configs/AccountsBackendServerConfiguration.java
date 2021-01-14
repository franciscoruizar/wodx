package ar.franciscoruiz.apps.accounts.backend.configs;

import ar.franciscoruiz.apps.accounts.backend.middleware.BasicHttpAuthMiddleware;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsBackendServerConfiguration {
    private final CommandBus bus;

    public AccountsBackendServerConfiguration(CommandBus bus) {
        this.bus = bus;
    }

    @Bean
    public FilterRegistrationBean<BasicHttpAuthMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<BasicHttpAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new BasicHttpAuthMiddleware(bus));
        registrationBean.addUrlPatterns("/users", "/companies", "/roles");

        return registrationBean;
    }
}
