package br.com.ada.bookstore.model;

public class Inventory {
    private Long productId;
    private Integer amount;

    public Inventory(Long product, Integer amount) {
        this.productId = product;
        this.amount = amount;
    }

    public Long getProductId() {
        return productId;
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
                "productId=" + productId +
                ", amount=" + amount +
                '}';
    }
}
