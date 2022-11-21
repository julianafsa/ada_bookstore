package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.ToyDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.ProductDatabase;
import br.com.ada.bookstore.model.Toy;

public class ToyDaoImpl extends AbstractGenericDao<Toy, Long> implements ToyDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        productDatabase.setEntityClass(Toy.class);
        return productDatabase;
    }
}
