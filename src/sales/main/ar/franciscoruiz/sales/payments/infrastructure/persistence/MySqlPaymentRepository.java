package ar.franciscoruiz.sales.payments.infrastructure.persistence;

import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentId;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class MySqlPaymentRepository extends HibernateRepository<Payment> implements PaymentRepository {
    public MySqlPaymentRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Payment.class);
    }

    @Override
    public void save(Payment payment) {
        persist(payment);
    }

    @Override
    public Optional<Payment> search(PaymentId id) {
        return byId(id);
    }

    @Override
    public List<Payment> searchByPurchase(PurchaseId id) {
        Filter   filter   = new Filter(new FilterField("purchaseId"), FilterOperator.EQUAL, new FilterValue(id.value()));
        Filters  filters  = new Filters(Collections.singletonList(filter));
        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
