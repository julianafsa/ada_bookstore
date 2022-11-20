package br.com.ada.bookstore.database.factory;

import br.com.ada.bookstore.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {

    private static Database instance;
    private List<Product> list;
    private static Long id = 0L;

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
            foundedItem = entity;
        }
    }

    /*@Override
    public Product findById(Long id) {
        Product foundedItem = null;
        for (Product item: list) {
            if (item.getId() == id) {
                foundedItem = item;
            }
        }
        return foundedItem;
    }*/

    public List<Product> findAll() {
        return Collections.unmodifiableList(list);
    }

    public void remove(Long id) {
        Product foundedItem = this.findById(id);
        if (foundedItem != null) {
            list.remove(foundedItem);
        }
    }

    public <T, K> T findById(K id) {
        Product foundedItem = null;
        for (Product item: list) {
            if (item.getId() == id) {
                foundedItem = item;
            }
        }
        return (T) foundedItem;
    }

    public <K> void remove(K id) {
        Product foundedItem = this.findById(id);
        if (foundedItem != null) {
            list.remove(foundedItem);
        }
    }


    //////


    /*public void save(Product item) {
        Product product = (Product) item;
        product.setId(++id);
        list.add(product);
    }*/

    /*public void update(Product product) {
        Product foundedItem = this.findById(product.getId());
        if (foundedItem != null) {
            foundedItem = product;
        }
    }*/

    /*@Override
    public Product findById(K id) {
        return null;
    }

    public Product findById(Long id) {
        Product foundedItem = null;
        for (Product item: list) {
            if (item.getId() == id) {
                foundedItem = item;
            }
        }
        return foundedItem;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public void remove(K id) {

    }

    public void remove(Long id) {
        Product foundedItem = this.findById(id);
        if (foundedItem != null) {
            list.remove(foundedItem);
        }
    }

    public <T, K> T findById(K id) {
        Product foundedItem = null;
        for (Product item: list) {
            if (item.getId() == id) {
                foundedItem = item;
            }
        }
        return (T) foundedItem;
    }

    public <K> void remove(K id) {
        Product foundedItem = this.findById(id);
        if (foundedItem != null) {
            list.remove(foundedItem);
        }
    }*/

}
