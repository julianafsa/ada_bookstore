package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public abstract class Product implements AdultAudienceProduct {
    private Long id;
    private String name;
    private BigDecimal price;
    private Boolean hasAdultAudience;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.hasAdultAudience = Boolean.FALSE;
    }

    public Product(String name, BigDecimal price, Boolean hasAdultAudience) {
        this.name = name;
        this.price = price;
        this.hasAdultAudience = hasAdultAudience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean hasAdultAudience() {
        return hasAdultAudience;
    }

    @Override
    public void setHasAdultAudience(Boolean hasAdultAudience) {
        this.hasAdultAudience = hasAdultAudience;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", hasAdultAudience=" + hasAdultAudience +
                '}';
    }
}
