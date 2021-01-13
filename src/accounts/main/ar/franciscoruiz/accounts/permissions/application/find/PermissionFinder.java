package ar.franciscoruiz.accounts.permissions.application.find;

import ar.franciscoruiz.accounts.permissions.application.PermissionResponse;
import ar.franciscoruiz.accounts.permissions.domain.PermissionId;
import ar.franciscoruiz.accounts.permissions.domain.PermissionNotExist;
import ar.franciscoruiz.accounts.permissions.domain.PermissionRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class PermissionFinder {
    private final PermissionRepository repository;

    public PermissionFinder(PermissionRepository repository) {
        this.repository = repository;
    }

    public PermissionResponse find(PermissionId id) {
        return this.repository.search(id)
            .map(PermissionResponse::fromAggregate)
            .orElseThrow(() -> new PermissionNotExist(id));
    }
}
