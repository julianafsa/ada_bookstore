package br.com.ada.bookstore.database;

import java.util.List;

public interface AbstractDatabase<T, K> {
    void save(T entity);
    void update(T entity);
    T findById(K id);
    List<T> findAll();
    void remove(K id);
}
