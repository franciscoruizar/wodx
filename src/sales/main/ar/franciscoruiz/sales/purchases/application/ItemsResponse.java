package ar.franciscoruiz.sales.purchases.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class ItemsResponse implements Response {
    private final List<ItemResponse> values;

    public ItemsResponse(List<ItemResponse> values) {
        this.values = values;
    }

    public List<ItemResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(ItemResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
