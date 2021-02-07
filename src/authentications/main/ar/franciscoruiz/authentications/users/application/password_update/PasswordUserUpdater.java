package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class PasswordUserUpdater {
    private final AuthenticationsUserRepository   repository;
    private final AuthenticationsUserFinderDomain userFinder;
    private final PasswordEncoder                 encoder;

    public PasswordUserUpdater(AuthenticationsUserRepository repository, AuthenticationsUserFinderDomain userFinder, PasswordEncoder encoder) {
        this.repository = repository;
        this.userFinder = userFinder;
        this.encoder    = encoder;
    }

    public void update(
        UserId id,
        AuthenticationsUserPassword oldPassword,
        AuthenticationsUserPassword newPassword
    ) {
        AuthenticationsUser user = getUser(id);

        ensureOldPassword(user, oldPassword);

        AuthenticationsUserPassword passwordEncode = new AuthenticationsUserPassword(encoder.encode(newPassword.value()));

        this.repository.save(new AuthenticationsUser(id, user.name(), user.surname(), user.email(), passwordEncode, user.phone(), user.isActive(), user.roleId()));
    }

    private void ensureOldPassword(AuthenticationsUser user, AuthenticationsUserPassword oldPassword) {
        boolean match = this.encoder.matches(oldPassword.value(), user.password().value());

        if (oldPassword.value().equals("") && user.password().value().equals("")) {
            match = true;
        }

        if (!match) {
            throw new InvalidOldCredential(oldPassword);
        }
    }

    private AuthenticationsUser getUser(UserId id) {
        return this.userFinder.find(id);
    }
}
