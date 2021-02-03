package ar.franciscoruiz.accounts.memberships.infrastructure.persistence;

import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlMembershipRepository extends HibernateRepository<Membership> implements MembershipRepository {
    public MySqlMembershipRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, Membership.class, "accounts");
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
