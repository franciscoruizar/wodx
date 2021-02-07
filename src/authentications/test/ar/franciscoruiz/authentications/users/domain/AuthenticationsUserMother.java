package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.roles.RoleIdMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.domain.users.UserIdMother;

public final class AuthenticationsUserMother {
    public static AuthenticationsUser create(
        UserId id,
        AuthenticationsUserName name,
        AuthenticationsUserSurname surname,
        AuthenticationsUserEmail email,
        AuthenticationsUserPassword password,
        AuthenticationsUserPhone phone,
        AuthenticationsUserIsActive isActive,
        RoleId roleId
    ) {
        return new AuthenticationsUser(id, name, surname, email, password, phone, isActive, roleId);
    }

    public static AuthenticationsUser random() {
        return create(
            UserIdMother.random(),
            AuthenticationsUserNameMother.random(),
            AuthenticationsUserSurnameMother.random(),
            AuthenticationsUserEmailMother.random(),
            AuthenticationsUserPasswordMother.random(),
            AuthenticationsUserPhoneMother.random(),
            AuthenticationsUserIsActiveMother.random(),
            RoleIdMother.random()
        );
    }
}
