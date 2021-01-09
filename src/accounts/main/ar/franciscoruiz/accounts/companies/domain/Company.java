package ar.franciscoruiz.accounts.companies.domain;

import java.util.Objects;

public final class Company {
    private final CompanyId          id;
    private final CompanyDescription description;

    public Company(CompanyId id, CompanyDescription description) {
        this.id          = id;
        this.description = description;
    }

    public Company() {
        this.id          = null;
        this.description = null;
    }

    public CompanyId id() {
        return this.id;
    }

    public CompanyDescription description() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) && Objects.equals(description, company.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
