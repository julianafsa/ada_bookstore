package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.ProductDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.ProductDatabase;

import br.com.ada.bookstore.model.Product;

public class ProductDaoImpl extends AbstractGenericDao<Product, Long> implements ProductDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        productDatabase.setEntityClass(Product.class);
        return productDatabase;
    }
}
