package br.com.ada.bookstore.model;

public class Item {
    private Product product;
    private Integer amount;

    public Item(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }
}
