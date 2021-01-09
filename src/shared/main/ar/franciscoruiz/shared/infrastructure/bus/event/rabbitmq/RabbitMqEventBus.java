package ar.franciscoruiz.shared.infrastructure.bus.event.rabbitmq;

import ar.franciscoruiz.shared.domain.bus.event.DomainEvent;
import ar.franciscoruiz.shared.domain.bus.event.EventBus;

import java.util.List;

public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final String            exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher, String exchangeName) {
        this.publisher    = publisher;
        this.exchangeName = exchangeName;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        this.publisher.publish(domainEvent, exchangeName);
    }
}
