package ar.franciscoruiz.apps.backoffice.frontend.controllers.health_check;

import ar.franciscoruiz.apps.shared.dto.HealthCheck;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class HealthCheckGetWebController extends ApiController {

    public HealthCheckGetWebController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/health-check")
    public String index(Model model) {
        HealthCheck healthCheck = new HealthCheck("mooc_backend", "ok");

        model.addAttribute(healthCheck);

        return "health-check";
    }
}
