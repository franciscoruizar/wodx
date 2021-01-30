package ar.franciscoruiz.apps.accounts.backend.controllers.purchases.shared.dto;

import ar.franciscoruiz.accounts.purchases.application.create.CreatePurchaseCommand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public final class PurchaseRequest {
    private String                    id;
    private String                    description;
    private LocalDateTime             date;
    private String                    userId;
    private List<PurchaseItemRequest> items;

    public PurchaseRequest(String id, String description, LocalDateTime date, String userId, List<PurchaseItemRequest> items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.items       = items;
    }

    public static CreatePurchaseCommand parseRequest(PurchaseRequest request){
        return new CreatePurchaseCommand(
            request.id(),
            request.description(),
            request.date(),
            request.userId(),
            request.items.stream().map(PurchaseItemRequest::parseRequest).collect(Collectors.toList())
        );
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String description() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime date() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String userId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<PurchaseItemRequest> items() {
        return this.items;
    }

    public void setItems(List<PurchaseItemRequest> items) {
        this.items = items;
    }
}
