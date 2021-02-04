package ar.franciscoruiz.apps.authentications.backend.controllers.users;

import ar.franciscoruiz.authentications.users.application.register.RegistryUserCommand;
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
public final class UserPostController extends ApiController {
    public UserPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<String> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new RegistryUserCommand(
            request.id(),
            request.name(),
            request.surname(),
            request.email(),
            request.phone(),
            request.phone()
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    static class Request {
        private String id;
        private String name;
        private String surname;
        private String email;
        private String phone;
        private String roleId;

        String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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


