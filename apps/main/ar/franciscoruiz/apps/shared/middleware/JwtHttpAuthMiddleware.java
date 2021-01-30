package ar.franciscoruiz.apps.shared.middleware;

import ar.franciscoruiz.accounts.auth.application.find_by_username.FindUserByUsernameQuery;
import ar.franciscoruiz.accounts.auth.application.find_by_username.UserDetailsResponse;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.Authorities;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.JWTUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class JwtHttpAuthMiddleware implements Filter {
    private final QueryBus bus;
    private final JWTUtil  jwtUtil;

    public JwtHttpAuthMiddleware(QueryBus bus, JWTUtil jwtUtil) {
        this.bus     = bus;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        String authorizationHeader = ((HttpServletRequest) request).getHeader("Authorization");

        if (hasIntroducedCredentials(authorizationHeader)){
            String jwt = authorizationHeader.substring(7);
            String username = jwtUtil.extractUsername(jwt);

            if (username == null){
                setInvalidCredentials(response);
            }

            UserDetailsResponse userDetailsResponse = this.bus.ask(new FindUserByUsernameQuery(username));

            var email = new AuthEmail(userDetailsResponse.username());
            var password = new AuthPassword(userDetailsResponse.password());
            var authorities = new Authorities(userDetailsResponse.authorities());

            if (!jwtUtil.validateToken(jwt, new AuthUser(email, password, authorities))){
                setInvalidCredentials(response);
            }
        }

        chain.doFilter(request, response);
    }

    private void setInvalidCredentials(ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.reset();
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    private boolean hasIntroducedCredentials(String authorizationHeader) {
        return null != authorizationHeader && authorizationHeader.startsWith("Bearer");
    }
}
