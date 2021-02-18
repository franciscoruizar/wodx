package ar.franciscoruiz.sales.payments.domain.services.create;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.items.domain.services.search_by_purchase.ItemByPurchaseDomainFinder;
import ar.franciscoruiz.sales.payments.domain.*;
import ar.franciscoruiz.sales.payments.domain.services.search_by_purchase.PaymentsByPurchaseDomainSearcher;
import ar.franciscoruiz.sales.payments.infrastructure.payment_gateways.PaymentGatewayFactory;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.sales.purchases.domain.services.find.PurchaseDomainFinder;
import ar.franciscoruiz.shared.domain.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public final class PaymentDomainCreator {
    private final PaymentRepository                repository;
    private final PaymentsByPurchaseDomainSearcher searcher;
    private final PurchaseDomainFinder             purchaseFinder;
    private final ItemByPurchaseDomainFinder       itemFinder;

    public PaymentDomainCreator(PaymentRepository repository, PurchaseRepository purchaseRepository, ItemRepository itemRepository) {
        this.repository     = repository;
        this.searcher       = new PaymentsByPurchaseDomainSearcher(repository);
        this.purchaseFinder = new PurchaseDomainFinder(purchaseRepository);
        this.itemFinder     = new ItemByPurchaseDomainFinder(itemRepository);
    }

    public void create(
        PaymentId id,
        PaymentMethod method,
        PaymentMount mount,
        PurchaseId purchaseId,
        LocalDateTime dateTime
    ) {
        ensurePayment(purchaseId, mount);

        try {
            PaymentGateway paymentGateway = new PaymentGatewayFactory().instance(method);

            paymentGateway.create(id, mount, purchaseId, dateTime);

            Payment payment = new Payment(id, method, mount, purchaseId, new PaymentStatus(true), dateTime);

            this.repository.save(payment);
        } catch (GatewayPaymentError error) {
            Payment payment = new Payment(id, method, mount, purchaseId, new PaymentStatus(false), dateTime);

            this.repository.save(payment);
        }
    }

    private void ensurePurchase(PurchaseId purchaseId) {
        this.purchaseFinder.find(purchaseId);
    }

    private void ensurePayment(PurchaseId purchaseId, PaymentMount mount) throws RuntimeException {
        ensurePurchase(purchaseId);
        List<Payment> payments = this.searcher.search(purchaseId);
        List<Item>    items    = this.itemFinder.find(purchaseId);

        final double totalPay   = Payment.totalPay(payments);
        final double totalMount = Item.totalPrice(items);

        if (totalPay == totalMount) {
            throw new RuntimeException(String.format("the purchase <%s> has already been paid", purchaseId.value()));
        }

        if (totalPay > totalMount) {
            final double differencePay = totalPay - totalMount;
            throw new RuntimeException(String.format("the purchase <%s> has already been paid and has $%s in favor, please make a credit note ", purchaseId.value(), differencePay));
        }

        final double totalPayable = totalMount - totalPay;

        if (mount.value() > totalPayable)
            throw new RuntimeException(String.format("the amount payable is greater than the remaining amount of the purchase %s", purchaseId.value()));
    }
}
