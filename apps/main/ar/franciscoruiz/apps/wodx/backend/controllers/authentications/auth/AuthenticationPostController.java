package ar.franciscoruiz.apps.wodx.backend.controllers.authentications.auth;

import ar.franciscoruiz.authentications.auth.application.authenticate.AuthenticateUserCommand;
import ar.franciscoruiz.authentications.auth.application.find_by_username.AuthUserDetailsResponse;
import ar.franciscoruiz.authentications.auth.application.find_by_username.FindAuthUserByEmailQuery;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.Authorities;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.shared.infrastructure.spring.SpringJwtUtil;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class AuthenticationPostController extends ApiController {
    private final SpringJwtUtil springJwtUtil;

    public AuthenticationPostController(QueryBus queryBus, CommandBus commandBus, SpringJwtUtil springJwtUtil) {
        super(queryBus, commandBus);
        this.springJwtUtil = springJwtUtil;
    }

    @PostMapping(value = "/authentications")
    public HashMap<String, Serializable> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new AuthenticateUserCommand(request.email(), request.password()));

        AuthUserDetailsResponse userDetailsResponse = ask(new FindAuthUserByEmailQuery(request.email()));

        var email       = new AuthEmail(userDetailsResponse.email());
        var password    = new AuthPassword(userDetailsResponse.password());
        var authorities = new Authorities(userDetailsResponse.authorities());

        String jwt = springJwtUtil.generateToken(new AuthUser(email, password, authorities));

        return new HashMap<>() {{
            put("jwt", jwt);
        }};
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String email;
        private String password;

        public String email() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String password() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}


