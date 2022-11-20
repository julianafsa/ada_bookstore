package br.com.ada.bookstore.model;

import java.math.BigDecimal;
import java.util.List;

public class Movie extends Product {
    private String studio;
    private List<String> directors;
    private String distributor;
    private List<String> genres;
    private List<String> producers;

    public Movie(String name, BigDecimal price) {
        super(name, price);
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }
}
