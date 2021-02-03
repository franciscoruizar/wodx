package ar.franciscoruiz.accounts.user_memberships.infrastructure.persistence;

import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlUserMembershipRepository extends HibernateRepository<UserMembership> implements UserMembershipRepository {
    public MySqlUserMembershipRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, UserMembership.class, "accounts");
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
