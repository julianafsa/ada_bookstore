package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.ToyDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.factory.Database;
import br.com.ada.bookstore.model.Toy;

public class ToyDaoImpl extends AbstractGenericDao<Toy, Long> implements ToyDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        return Database.getInstance();
    }
}
