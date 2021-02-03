package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class PasswordAuthUserUpdater {
    private final AuthUserRepository repository;
    private final UserFinderDomain   userFinder;
    private final PasswordEncoder    encoder;

    public PasswordAuthUserUpdater(AuthUserRepository repository, UserFinderDomain userFinder, PasswordEncoder encoder) {
        this.repository = repository;
        this.userFinder = userFinder;
        this.encoder    = encoder;
    }

    public void update(
        UserId id,
        UserPassword oldPassword,
        UserPassword newPassword
    ) {
        User user = getUser(id);

        ensureOldPassword(user, oldPassword);

        UserPassword passwordEncode = new UserPassword(encoder.encode(newPassword.value()));

        this.repository.save(new User(id, user.name(), user.surname(), user.email(), passwordEncode, user.phone(), user.isActive(), user.roleId()));
    }

    private void ensureOldPassword(User user, UserPassword oldPassword) {
        boolean match = this.encoder.matches(oldPassword.value(), user.password().value());

        if (!match) {
            throw new InvalidOldCredential(oldPassword);
        }
    }

    private User getUser(UserId id) {
        return this.userFinder.find(id);
    }
}
