package ar.franciscoruiz.accounts.user_memberships.infrastructure.persistence;

import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
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
public final class MySqlUserMembershipRepository extends HibernateRepository<UserMembership> implements UserMembershipRepository {
    public MySqlUserMembershipRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, UserMembership.class);
    }

    @Override
    public void save(UserMembership entity) {
        persist(entity);
    }

    @Override
    public Optional<UserMembership> search(UserMembershipId id) {
        return byId(id.value());
    }

    @Override
    public List<UserMembership> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
