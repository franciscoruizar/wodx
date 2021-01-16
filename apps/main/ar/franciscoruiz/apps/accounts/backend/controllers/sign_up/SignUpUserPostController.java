package ar.franciscoruiz.apps.accounts.backend.controllers.sign_up;

import ar.franciscoruiz.accounts.sign_up.application.register.RegisterUserAthleteCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class SignUpUserPostController extends ApiController {
    public SignUpUserPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/athlete")
    public ResponseEntity<String> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new RegisterUserAthleteCommand(
                request.id(),
                request.name(),
                request.surname(),
                request.email(),
                request.password(),
                request.phone()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

class Request {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String surname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    public String phone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
