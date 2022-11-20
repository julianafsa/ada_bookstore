package br.com.ada.bookstore.model;

import java.math.BigDecimal;
import java.util.List;

public class Album extends Product {
    private List<String> players;
    private List<String> genres;
    private List<String> seals;

    public Album(String name, BigDecimal price) {
        super(name, price);
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getSeals() {
        return seals;
    }

    public void setSeals(List<String> seals) {
        this.seals = seals;
    }
}
