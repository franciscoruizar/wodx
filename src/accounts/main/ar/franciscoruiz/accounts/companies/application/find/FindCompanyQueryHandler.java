package ar.franciscoruiz.accounts.companies.application.find;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class FindCompanyQueryHandler implements QueryHandler<FindCompanyQuery, CompanyResponse> {
    private final CompanyFinder finder;

    public FindCompanyQueryHandler(CompanyFinder finder) {
        this.finder = finder;
    }

    @Override
    public CompanyResponse handle(FindCompanyQuery query) {
        CompanyId id = new CompanyId(query.id());

        return this.finder.find(id);
    }
}
