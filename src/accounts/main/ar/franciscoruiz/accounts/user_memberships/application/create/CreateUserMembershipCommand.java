package ar.franciscoruiz.accounts.user_memberships.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

import java.time.LocalDate;

public final class CreateUserMembershipCommand implements Command {
    private final String    id;
    private final LocalDate dateFrom;
    private final String    membershipId;
    private final String    userId;

    public CreateUserMembershipCommand(String id, LocalDate dateFrom, String membershipId, String userId) {
        this.id           = id;
        this.dateFrom     = dateFrom;
        this.membershipId = membershipId;
        this.userId       = userId;
    }

    public String id() {
        return this.id;
    }

    public LocalDate dateFrom() {
        return this.dateFrom;
    }

    public String membershipId() {
        return this.membershipId;
    }

    public String userId() {
        return this.userId;
    }
}
