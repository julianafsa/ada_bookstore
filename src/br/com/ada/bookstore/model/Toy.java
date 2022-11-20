package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public class Toy extends Product {
    private String type;

    public Toy(String name, BigDecimal price) {
        super(name, price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Toy{" +
                super.toString() +
                ", type='" + type + '\'' +
                '}';
    }
}
