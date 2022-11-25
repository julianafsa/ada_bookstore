package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public class AdultAudienceBook extends Book implements AdultAudienceProduct {

    public AdultAudienceBook(String name, BigDecimal price) {
        super(name, price);
    }
}
