package br.com.ada.bookstore.model;

import java.util.List;

public class AdultAudienceOrder extends Order {
    private Customer customer;

    public AdultAudienceOrder(List<Item> itens, Customer customer) {
        super(itens);
        this.customer = customer;
    }


}
