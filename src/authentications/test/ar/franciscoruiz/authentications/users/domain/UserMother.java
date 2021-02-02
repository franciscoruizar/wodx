package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.roles.RoleIdMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.domain.users.UserIdMother;

public final class UserMother {
    public static User create(
        UserId id,
        UserName name,
        UserSurname surname,
        UserEmail email,
        UserPassword password,
        UserPhone phone,
        UserIsActive isActive,
        RoleId roleId
    ) {
        return new User(id, name, surname, email, password, phone, isActive, roleId);
    }

    public static User random() {
        return create(
            UserIdMother.random(),
            UserNameMother.random(),
            UserSurnameMother.random(),
            UserEmailMother.random(),
            UserPasswordMother.random(),
            UserPhoneMother.random(),
            UserIsActiveMother.random(),
            RoleIdMother.random()
        );
    }
}
