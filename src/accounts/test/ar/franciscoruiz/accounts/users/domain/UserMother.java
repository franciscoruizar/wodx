package ar.franciscoruiz.accounts.users.domain;

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
        UserPhone phone,
        UserIsActive isActive,
        RoleId roleId
    ) {
        return new User(id.value(), name.value(), surname.value(), email.value(), phone.value(), isActive.value(), roleId.value());
    }

    public static User random() {
        return create(
            UserIdMother.random(),
            UserNameMother.random(),
            UserSurnameMother.random(),
            UserEmailMother.random(),
            UserPhoneMother.random(),
            UserIsActiveMother.random(),
            RoleIdMother.random()
        );
    }
}
