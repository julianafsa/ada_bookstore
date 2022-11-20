package br.com.ada.bookstore.dao;

import java.util.List;

public interface GenericDao<T, K> {
    void save(T entity);
    void update(T entity);
    T findById(K id);
    List<T> findAll();
    void remove(K id);
}