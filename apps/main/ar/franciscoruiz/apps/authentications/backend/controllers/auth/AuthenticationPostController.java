package ar.franciscoruiz.apps.authentications.backend.controllers.auth;

import ar.franciscoruiz.authentications.auth.application.authenticate.AuthenticateUserCommand;
import ar.franciscoruiz.authentications.auth.application.find_by_username.FindUserByUsernameQuery;
import ar.franciscoruiz.authentications.auth.application.find_by_username.UserDetailsResponse;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.Authorities;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.shared.infrastructure.spring.SpringJwtUtil;
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

    @PostMapping(value = "/auth")
    public HashMap<String, Serializable> index(
        @RequestBody AuthRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(new AuthenticateUserCommand(request.username(), request.password()));

        UserDetailsResponse userDetailsResponse = ask(new FindUserByUsernameQuery(request.username()));

        var email       = new AuthEmail(userDetailsResponse.username());
        var password    = new AuthPassword(userDetailsResponse.password());
        var authorities = new Authorities(userDetailsResponse.authorities());

        String jwt = springJwtUtil.generateToken(new AuthUser(email, password, authorities));

        return new HashMap<>() {{
            put("jwt", jwt);
        }};
    }
}

class AuthRequest {
    private String username;
    private String password;

    public String username() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String password() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
