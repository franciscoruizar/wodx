package ar.franciscoruiz.authentications.users.application.find_by_username;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserByEmailQueryHandler implements QueryHandler<FindUserByEmailQuery, UserResponse> {
    private final UserByEmailFinder authenticator;

    public FindUserByEmailQueryHandler(UserByEmailFinder authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public UserResponse handle(FindUserByEmailQuery command) {
        AuthEmail email = new AuthEmail(command.email());

        return authenticator.find(email);
    }
}
