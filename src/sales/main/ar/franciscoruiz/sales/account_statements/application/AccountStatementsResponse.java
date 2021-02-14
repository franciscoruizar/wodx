package ar.franciscoruiz.sales.account_statements.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class AccountStatementsResponse implements Response {
    private final List<AccountStatementResponse> values;

    public AccountStatementsResponse(List<AccountStatementResponse> values) {
        this.values = values;
    }

    public List<HashMap<String, Object>> toPrimitives() {
        return this.values
            .stream()
            .map(AccountStatementResponse::toPrimitives)
            .collect(Collectors.toList());
    }

}
