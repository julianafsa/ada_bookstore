package br.com.ada.bookstore.dao;

import br.com.ada.bookstore.database.factory.Database;
import br.com.ada.bookstore.model.Product;

import java.util.List;

public abstract class AbstractGenericDao<T, K> implements GenericDao<T, K> {

    private Database database = Database.getInstance();

    @Override
    public void save(T entity) {
        Product product = (Product) entity;
        database.save(product);
        System.out.println("Saving " + entity.getClass().getSimpleName() + ": " + product.toString());
    }

    @Override
    public void update(T entity) {
        Product product = (Product) entity;
        System.out.println("Updating " + entity.getClass().getSimpleName() + ": " + product.toString());
        database.update(product);
    }

    @Override
    public T findById(K id) {
        System.out.println("Searching item with id = " + id + "...");
        return database.findById(id);
    }

    @Override
    public List<T> findAll() {
        System.out.println("Searching all products...");
        return (List<T>) database.findAll();
    }

    @Override
    public void remove(K id) {
        System.out.println("Removing item with id = " + id + "...");
        database.remove(id);
    }
}
