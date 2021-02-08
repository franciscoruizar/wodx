package ar.franciscoruiz.apps.accounts.backend.controllers.companies;

import ar.franciscoruiz.accounts.companies.application.create.CreateCompanyCommand;
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
public final class CompanyPutController extends ApiController {
    public CompanyPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateCompanyCommand(
                id,
                request.description(),
                request.mediaUrl(),
                request.latitude(),
                request.longitude(),
                request.isActive()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String  description;
        private String  mediaUrl;
        private Double  latitude;
        private Double  longitude;
        private boolean isActive;

        public String description() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String mediaUrl() {
            return this.mediaUrl;
        }

        public void setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
        }

        public Double latitude() {
            return this.latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double longitude() {
            return this.longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Boolean isActive() {
            return this.isActive;
        }

        public void setActive(Boolean active) {
            isActive = active;
        }
    }
}
