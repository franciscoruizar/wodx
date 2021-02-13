package ar.franciscoruiz.accounts.memberships.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.accounts.memberships.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        return byId(id);
    }

    @Override
    public List<Membership> findByCompany(CompanyId companyId) {
        Session session = sessionFactory.openSession();

        String sql   = String.format("SELECT id, description, number_days_enabled, price, company_id, is_active FROM memberships WHERE company_id = '%s'", companyId.value());
        Query  query = session.createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        session.close();

        return result.stream().map(objects -> new Membership(
            new MembershipId((String) objects[0]),
            new MembershipDescription((String) objects[1]),
            new MembershipNumberDaysEnabled((Integer) objects[2]),
            new MembershipPrice(Double.valueOf(String.valueOf(objects[3]))),
            new CompanyId((String) objects[4]),
            new MembershipIsActive((Boolean) objects[5])
        )).collect(Collectors.toList());
    }
}
