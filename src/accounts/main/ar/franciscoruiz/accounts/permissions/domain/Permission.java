package ar.franciscoruiz.accounts.permissions.domain;

import java.util.Objects;

public final class Permission {
    private final PermissionId     id;
    private final PermissionEntity entity;
    private final Boolean          create;
    private final Boolean          update;
    private final Boolean          delete;
    private final Boolean          read;
    private final Boolean          readAll;

    public Permission(
        PermissionId id,
        PermissionEntity entity,
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

    public Permission() {
        this.id      = null;
        this.entity  = null;
        this.create  = null;
        this.update  = null;
        this.delete  = null;
        this.read    = null;
        this.readAll = null;
    }

    public PermissionId id() {
        return this.id;
    }

    public PermissionEntity entity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) && Objects.equals(entity, that.entity) && Objects.equals(create, that.create) && Objects.equals(update, that.update) && Objects.equals(delete, that.delete) && Objects.equals(read, that.read) && Objects.equals(readAll, that.readAll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entity, create, update, delete, read, readAll);
    }
}
