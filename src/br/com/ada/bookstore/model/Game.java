package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public class Game extends Product {
    private String distributor;
    private String genre;
    private String studio;

    public Game(String name, BigDecimal price) {
        super(name, price);
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
