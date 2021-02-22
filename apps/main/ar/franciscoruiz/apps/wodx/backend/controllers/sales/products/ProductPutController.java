package ar.franciscoruiz.apps.wodx.backend.controllers.sales.products;

import ar.franciscoruiz.sales.products.application.material_product.create.CreateMaterialProductCommand;
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
public final class ProductPutController extends ApiController {
    public ProductPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<String> index(
        @RequestBody Request request,
        @PathVariable String id
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateMaterialProductCommand(
                id,
                request.title(),
                request.description(),
                request.price(),
                request.isActive(),
                request.companyId(),
                request.weight()
            )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String  title;
        private String  description;
        private Double  price;
        private boolean isActive;
        private String  companyId;
        private Integer weight;

        public String title() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String description() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double price() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public String companyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public Integer weight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }
}
