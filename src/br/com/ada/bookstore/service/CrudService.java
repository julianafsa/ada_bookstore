package br.com.ada.bookstore.service;

import java.util.List;

public interface CrudService<T, K> {
    void save(T entity);
    void update(T entity);
    T findById(K id);
    List<T> findAll();
    void remove(K id);
}
