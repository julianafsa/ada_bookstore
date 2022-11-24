package br.com.ada.bookstore.model;

public interface QuantityManager<T> {
    public void addBalance(T balance);
    public void reduceBalance(T balance);
}
