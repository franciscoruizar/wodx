package ar.franciscoruiz.apps.authentications.backend.controllers.users;

import ar.franciscoruiz.authentications.users.application.password_update.UpdatePasswordUserCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserPasswordPutController extends ApiController {
    public UserPasswordPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/users/password")
    public ResponseEntity<String> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new UpdatePasswordUserCommand(
            request.id(),
            request.oldPassword(),
            request.newPassword()
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    static class Request {
        private String id;
        private String oldPassword;
        private String newPassword;

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String oldPassword() {
            return oldPassword;
        }

        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String newPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}


