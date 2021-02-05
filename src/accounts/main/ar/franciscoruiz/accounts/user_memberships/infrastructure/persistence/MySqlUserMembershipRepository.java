package ar.franciscoruiz.accounts.user_memberships.infrastructure.persistence;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.shared.domain.Identifier;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlUserMembershipRepository extends HibernateRepository<UserMembership> implements UserMembershipRepository {
    private final Class<UserMembership> aggregateClass;

    public MySqlUserMembershipRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, UserMembership.class);
        this.aggregateClass = UserMembership.class;
    }

    @Override
    public void save(UserMembership entity) {
        persist(entity);
    }

    @Override
    public Optional<UserMembership> search(UserMembershipId id) {
        return byId(id);
    }

    @Override
    public List<UserMembership> searchByUser(UserId userId) {
        return searchByCriteria(userId, "user_id");
    }

    @Override
    public List<UserMembership> searchByMembership(MembershipId membershipId) {
        return searchByCriteria(membershipId, "membership_id");
    }

    public List<UserMembership> searchByCriteria(Identifier identifier, String field) {
        FilterField    filterField    = new FilterField(field);
        FilterOperator filterOperator = FilterOperator.EQUAL;
        FilterValue    filterValue    = new FilterValue(identifier.value());
        Filter         filter         = new Filter(filterField, filterOperator, filterValue);
        Filters filters = new Filters(new ArrayList<>() {{
            add(filter);
        }});

        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria);
    }
}
