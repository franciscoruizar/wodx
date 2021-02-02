package ar.franciscoruiz.apps.authentications.backend.controllers.health_check;

import ar.franciscoruiz.apps.shared.dto.HealthCheck;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HealthCheckGetController extends ApiController {
    public HealthCheckGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/health-check")
    public HealthCheck index() {
        return new HealthCheck("workouts_backend", "ok");
    }
}
