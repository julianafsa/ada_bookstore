package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public class Book extends Product {
    private String genre;
    private String author;
    private String publisher;

    public Book(String name, BigDecimal price) {
        super(name, price);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
