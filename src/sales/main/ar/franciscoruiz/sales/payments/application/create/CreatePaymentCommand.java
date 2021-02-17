package ar.franciscoruiz.sales.payments.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

import java.time.LocalDateTime;

public final class CreatePaymentCommand implements Command {
    private final String        id;
    private final String        method;
    private final Double        mount;
    private final String        purchaseId;
    private final LocalDateTime dateTime;

    public CreatePaymentCommand(String id, String method, Double mount, String purchaseId, LocalDateTime dateTime) {
        this.id         = id;
        this.method     = method;
        this.mount      = mount;
        this.purchaseId = purchaseId;
        this.dateTime   = dateTime;
    }

    public String id() {
        return id;
    }

    public String method() {
        return method;
    }

    public Double mount() {
        return mount;
    }

    public String purchaseId() {
        return purchaseId;
    }

    public LocalDateTime dateTime() {
        return dateTime;
    }
}
