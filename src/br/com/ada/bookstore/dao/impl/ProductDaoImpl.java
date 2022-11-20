package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.ProductDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.factory.Database;

import br.com.ada.bookstore.model.Product;

public class ProductDaoImpl extends AbstractGenericDao<Product, Long> implements ProductDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        Database database = Database.getInstance();
        database.setEntityClass(Product.class);
        return database;
    }
}
