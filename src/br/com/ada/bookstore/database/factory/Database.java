package br.com.ada.bookstore.database.factory;

import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database implements AbstractDatabase<Product, Long> {

    private static Database instance;
    private final List<Product> list;
    private static Long id = 0L;
    private Class entityClass;

    private Database() {
        list = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void save(Product entity) {
        entity.setId(++id);
        list.add(entity);
    }

    public void update(Product entity) {
        Product foundedItem = this.findById(entity.getId());
        if (foundedItem != null) {
            int index = list.indexOf(foundedItem);
            list.add(index, entity);
            list.remove(index+1);
        }
    }

    public Product findById(Long id) {
        Product foundedItem = null;
        for (Product item: list) {
            if (item.getId().equals(id)) {
                foundedItem = item;
            }
        }
        return foundedItem;
    }

    public List<Product> findAll() {
        //return Collections.unmodifiableList(list);
        List<Product> filteredList = new ArrayList<>();
        for (Product item: list) {
            if (item.getClass() == this.getEntityClass() ||
                    item.getClass().getSuperclass() == this.getEntityClass()) {
                filteredList.add(item);
            }
        }
        return Collections.unmodifiableList(filteredList);
    }

    public void remove(Long id) {
        Product foundedItem = this.findById(id);
        if (foundedItem != null) {
            list.remove(foundedItem);
        }
    }

    @Override
    public void setEntityClass(Class currentClass) {
        this.entityClass = currentClass;
    }

    @Override
    public Class getEntityClass() {
        return entityClass;
    }

}
