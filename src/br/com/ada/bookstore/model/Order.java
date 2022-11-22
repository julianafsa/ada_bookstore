package br.com.ada.bookstore.model;

import java.util.List;

public class Order {
    private Long id;
    private List<Item> itens;

    public Order(List<Item> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    public void removeItem(final Item item) {
        itens.remove(item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itens=" + itens +
                '}';
    }
}
