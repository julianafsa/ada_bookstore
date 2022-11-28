package br.com.ada.bookstore.model;

import br.com.ada.bookstore.model.customer.Customer;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private List<Item> items;
    private Customer customer;

    public Order(List<Item> itens) {
        this.items = itens;
    }

    public Order(List<Item> itens, Customer customer) {
        this.items = itens;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(final Item item) {
        items.remove(item);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalOrderValue() {
        BigDecimal totalOrderValue = BigDecimal.ZERO;
        for (Item item: items) {
            final BigDecimal itemValue = item.getProduct().getPrice();
            final BigDecimal itemAmount = new BigDecimal(Integer.toString(item.getAmount()));
            final BigDecimal totalPerItem = itemValue.multiply(itemAmount);
            totalOrderValue = totalOrderValue.add(totalPerItem);
        }
        return totalOrderValue;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itens=" + items +
                '}';
    }
}
