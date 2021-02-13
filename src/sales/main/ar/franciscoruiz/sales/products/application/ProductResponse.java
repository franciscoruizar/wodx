package ar.franciscoruiz.sales.products.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;

public class ProductResponse implements Response {
    private final String  id;
    private final String  title;
    private final String  description;
    private final Double  price;
    private final boolean isActive;
    private final String  companyId;

    public ProductResponse(String id, String title, String description, Double price, boolean isActive, String companyId) {
        this.id          = id;
        this.title       = title;
        this.description = description;
        this.price       = price;
        this.isActive    = isActive;
        this.companyId   = companyId;
    }

    protected HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("title", this.title);
        response.put("description", this.description);
        response.put("price", this.price);
        response.put("is_active", this.isActive);
        response.put("company_id", this.companyId);

        return response;
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public Double price() {
        return price;
    }

    public boolean isActive() {
        return isActive;
    }

    public String companyId() {
        return companyId;
    }
}
