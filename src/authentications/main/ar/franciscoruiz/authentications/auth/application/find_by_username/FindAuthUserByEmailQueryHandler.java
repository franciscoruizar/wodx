package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindAuthUserByEmailQueryHandler implements QueryHandler<FindAuthUserByEmailQuery, AuthUserDetailsResponse> {
    private final AuthUserByEmailFinder authenticator;

    public FindAuthUserByEmailQueryHandler(AuthUserByEmailFinder authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public AuthUserDetailsResponse handle(FindAuthUserByEmailQuery command) {
        AuthEmail email = new AuthEmail(command.email());

        return authenticator.find(email);
    }
}
