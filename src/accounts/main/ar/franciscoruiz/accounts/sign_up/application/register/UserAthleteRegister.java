package ar.franciscoruiz.accounts.sign_up.application.register;

import ar.franciscoruiz.accounts.sign_up.domain.*;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserAthleteRegister {
    private final SignUpUserRepository repository;

    public UserAthleteRegister(SignUpUserRepository repository) {
        this.repository = repository;
    }

    public void save(
        SignUpUserId id,
        SignUpUserName name,
        SignUpUserSurname surname,
        SignUpUserEmail email,
        SignUpUserPassword password,
        SignUpUserPhone phone
    ) {
        SignUpUser user = new SignUpUser(id, name, surname, email, password, phone);

        this.repository.save(user);
    }
}
