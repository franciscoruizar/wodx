package ar.franciscoruiz.sales.payments.application.create;

import ar.franciscoruiz.sales.payments.domain.PaymentId;
import ar.franciscoruiz.sales.payments.domain.PaymentMethod;
import ar.franciscoruiz.sales.payments.domain.PaymentMount;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreatePaymentCommandHandler implements CommandHandler<CreatePaymentCommand> {
    private final PaymentCreator creator;

    public CreatePaymentCommandHandler(PaymentCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreatePaymentCommand command) {
        PaymentId     id         = new PaymentId(command.id());
        PaymentMethod method     = PaymentMethod.valueOf(command.method());
        PaymentMount  mount      = new PaymentMount(command.mount());
        PurchaseId    purchaseId = new PurchaseId(command.purchaseId());

        this.creator.create(id, method, mount, purchaseId, command.dateTime());
    }
}
