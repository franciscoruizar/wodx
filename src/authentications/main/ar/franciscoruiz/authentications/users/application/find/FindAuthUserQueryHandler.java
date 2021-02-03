package ar.franciscoruiz.authentications.users.application.find;

import ar.franciscoruiz.authentications.users.application.UserResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class FindAuthUserQueryHandler implements QueryHandler<FindAuthUserQuery, UserResponse> {
    private final AuthUserFinder finder;

    public FindAuthUserQueryHandler(AuthUserFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindAuthUserQuery query) {
        UserId id = new UserId(query.id());

        return this.finder.find(id);
    }
}
