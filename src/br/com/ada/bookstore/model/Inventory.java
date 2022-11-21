package br.com.ada.bookstore.model;

public class Inventory {
    private Product product;
    private Integer amount;

    public Inventory(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void reduceAmount(Integer amount) {
        this.amount -= amount;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }
}
