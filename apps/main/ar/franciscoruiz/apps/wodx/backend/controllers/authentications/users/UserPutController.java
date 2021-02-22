package ar.franciscoruiz.apps.wodx.backend.controllers.authentications.users;

import ar.franciscoruiz.authentications.users.application.register.RegisterUserCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserPutController extends ApiController {
    public UserPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/authentications/users/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new RegisterUserCommand(
            id,
            request.name(),
            request.surname(),
            request.email(),
            request.phone(),
            request.roleId()
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String name;
        private String surname;
        private String email;
        private String phone;
        private String roleId;

        String name() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String surname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        String email() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        String phone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String roleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }
    }
}


