package ar.franciscoruiz.accounts.permissions.application;

import ar.franciscoruiz.accounts.permissions.domain.Permission;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class PermissionResponse implements Response {
    private final String  id;
    private final String  entity;
    private final Boolean create;
    private final Boolean update;
    private final Boolean delete;
    private final Boolean read;
    private final Boolean readAll;

    public static PermissionResponse fromAggregate(Permission permission) {
        return new PermissionResponse(
            permission.id().value(),
            permission.entity().value(),
            permission.create(),
            permission.update(),
            permission.delete(),
            permission.read(),
            permission.readAll()
        );
    }

    public PermissionResponse(
        String id,
        String entity,
        Boolean create,
        Boolean update,
        Boolean delete,
        Boolean read,
        Boolean readAll
    ) {
        this.id      = id;
        this.entity  = entity;
        this.create  = create;
        this.update  = update;
        this.delete  = delete;
        this.read    = read;
        this.readAll = readAll;
    }

    public String id() {
        return this.id;
    }

    public String entity() {
        return this.entity;
    }

    public Boolean create() {
        return this.create;
    }

    public Boolean update() {
        return this.update;
    }

    public Boolean delete() {
        return this.delete;
    }

    public Boolean read() {
        return this.read;
    }

    public Boolean readAll() {
        return this.readAll;
    }
}
