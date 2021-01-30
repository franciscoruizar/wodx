package ar.franciscoruiz.apps.accounts.backend.configs;

import ar.franciscoruiz.apps.shared.middleware.JwtHttpAuthMiddleware;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.JWTUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsBackendServerConfiguration {
    private final QueryBus bus;
    private final JWTUtil  jwtUtil;

    public AccountsBackendServerConfiguration(QueryBus bus, JWTUtil jwtUtil) {
        this.bus     = bus;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public FilterRegistrationBean<JwtHttpAuthMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<JwtHttpAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtHttpAuthMiddleware(bus, jwtUtil));
        registrationBean.addUrlPatterns("/users", "/companies", "/roles");

        return registrationBean;
    }
}
