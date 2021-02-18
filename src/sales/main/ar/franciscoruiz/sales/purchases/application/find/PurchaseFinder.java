package ar.franciscoruiz.sales.purchases.application.find;

import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.items.domain.services.search_by_purchase.ItemByPurchaseDomainFinder;
import ar.franciscoruiz.sales.payments.application.PaymentsResponse;
import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.payments.domain.services.search_by_purchase.PaymentsByPurchaseDomainSearcher;
import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.sales.purchases.domain.services.find.PurchaseDomainFinder;
import ar.franciscoruiz.shared.domain.Service;

import java.util.List;

@Service
public final class PurchaseFinder {
    private final PurchaseDomainFinder             finder;
    private final ItemByPurchaseDomainFinder       itemFinder;
    private final PaymentsByPurchaseDomainSearcher paymentsSearcher;

    public PurchaseFinder(PurchaseRepository repository, ItemRepository itemRepository, PaymentRepository paymentRepository) {
        this.finder           = new PurchaseDomainFinder(repository);
        this.itemFinder       = new ItemByPurchaseDomainFinder(itemRepository);
        this.paymentsSearcher = new PaymentsByPurchaseDomainSearcher(paymentRepository);
    }

    public PurchaseResponse find(PurchaseId id) {
        final Purchase      purchase = this.finder.find(id);
        final List<Item>    items    = searchItemsByPurchase(id);
        final List<Payment> payments = searchPaymentsByPurchase(id);

        final double totalPrice = Item.totalPrice(items);
        final double totalPay   = Payment.totalPay(payments);

        return new PurchaseResponse(
            purchase.id().value(),
            purchase.description().value(),
            purchase.date(),
            purchase.userId().value(),
            purchase.companyId().value(),
            totalPrice,
            totalPay,
            totalPay >= totalPrice,
            ItemsResponse.fromAggregate(items),
            PaymentsResponse.fromAggregate(payments)
        );
    }

    private List<Payment> searchPaymentsByPurchase(PurchaseId id) {
        return this.paymentsSearcher.search(id);
    }

    private List<Item> searchItemsByPurchase(PurchaseId purchaseId) {
        return this.itemFinder.find(purchaseId);
    }
}
