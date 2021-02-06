package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindAuthUserByEmailQueryHandler implements QueryHandler<FindAuthUserByEmailQuery, AuthUserDetailsResponse> {
    private final AuthUserByEmailFinder finder;

    public FindAuthUserByEmailQueryHandler(AuthUserByEmailFinder finder) {
        this.finder = finder;
    }

    @Override
    public AuthUserDetailsResponse handle(FindAuthUserByEmailQuery command) {
        AuthEmail email = new AuthEmail(command.email());

        return finder.find(email);
    }
}
