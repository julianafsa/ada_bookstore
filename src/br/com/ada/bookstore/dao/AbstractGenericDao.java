package br.com.ada.bookstore.dao;

import br.com.ada.bookstore.database.AbstractDatabase;

import java.util.List;

public abstract class AbstractGenericDao<T, K> implements GenericDao<T, K> {

    private AbstractDatabase abstractDatabase = getAbstractDatabase();

    @Override
    public void save(T entity) {
//        Product product = (Product) entity;
//        database.save(product);
        abstractDatabase.save(entity);
        System.out.println("Saving " + entity.getClass().getSimpleName() + ": " + entity.toString());
    }

    @Override
    public void update(T entity) {
        abstractDatabase.update(entity);
        System.out.println("Updating " + entity.getClass().getSimpleName() + ": " + entity.toString());
    }

    @Override
    public T findById(K id) {
        System.out.println("Searching item with id = " + id + "...");
        return (T) abstractDatabase.findById(id);
    }

    @Override
    public List<T> findAll() {
        System.out.println("Searching all products...");
        return abstractDatabase.findAll();
    }

    @Override
    public void remove(K id) {
        System.out.println("Removing item with id = " + id + "...");
        abstractDatabase.remove(id);
    }

    public abstract AbstractDatabase getAbstractDatabase();
    //public abstract Class getEntityClass();

}
