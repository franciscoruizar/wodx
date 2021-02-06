package ar.franciscoruiz.authentications.users.application.find_by_username;

import ar.franciscoruiz.authentications.users.domain.UserEmail;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserByEmailQueryHandler implements QueryHandler<FindUserByEmailQuery, UserResponse> {
    private final UserByEmailFinder finder;

    public FindUserByEmailQueryHandler(UserByEmailFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindUserByEmailQuery command) {
        UserEmail email = new UserEmail(command.email());

        return finder.find(email);
    }
}
