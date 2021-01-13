package ar.franciscoruiz.accounts.permissions.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class PermissionsResponse implements Response {
    private final List<PermissionResponse> values;

    public PermissionsResponse(List<PermissionResponse> values) {
        this.values = values;
    }

    public List<PermissionResponse> values() {
        return this.values;
    }
}
