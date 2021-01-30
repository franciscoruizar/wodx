package ar.franciscoruiz.accounts.memberships.infrastructure.persistence;

import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlMembershipRepository extends HibernateRepository<Membership> implements MembershipRepository {
    public MySqlMembershipRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Membership.class);
    }

    @Override
    public void save(Membership entity) {
        persist(entity);
    }

    @Override
    public Optional<Membership> search(MembershipId id) {
        return byId(id.value());
    }

    @Override
    public List<Membership> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
