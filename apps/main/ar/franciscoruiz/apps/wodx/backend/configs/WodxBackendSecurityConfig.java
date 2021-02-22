package ar.franciscoruiz.apps.wodx.backend.configs;

import ar.franciscoruiz.apps.shared.configs.SpringWebSecurityConfig;
import ar.franciscoruiz.apps.shared.middleware.JwtHttpAuthMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WodxBackendSecurityConfig extends SpringWebSecurityConfig {

    @Autowired
    private JwtHttpAuthMiddleware middleware;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("health-check", "/authentications/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(middleware, UsernamePasswordAuthenticationFilter.class);
    }
}
