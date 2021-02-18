package ar.franciscoruiz.sales.payments.application.create;

import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.payments.domain.PaymentId;
import ar.franciscoruiz.sales.payments.domain.PaymentMethod;
import ar.franciscoruiz.sales.payments.domain.PaymentMount;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.payments.domain.services.create.PaymentDomainCreator;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.time.LocalDateTime;

@Service
public final class PaymentCreator {
    private final PaymentDomainCreator creator;

    public PaymentCreator(PaymentRepository repository, PurchaseRepository purchaseRepository, ItemRepository itemRepository) {
        this.creator = new PaymentDomainCreator(repository, purchaseRepository, itemRepository);
    }

    public void create(
        PaymentId id,
        PaymentMethod method,
        PaymentMount mount,
        PurchaseId purchaseId,
        LocalDateTime dateTime
    ) {
        this.creator.create(id, method, mount, purchaseId, dateTime);
    }
}
