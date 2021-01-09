package ar.franciscoruiz.accounts.users.domain.employee;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class Employee extends User {
    public Employee(UserId id, UserEmail email, UserPassword password) {
        super(id, email, password, Role.EMPLOYEE);
    }

    public Employee() {
        super(null, null, null, null);
    }
}
