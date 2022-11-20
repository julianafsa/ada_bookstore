package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.GameDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.factory.Database;
import br.com.ada.bookstore.model.Game;

public class GameDaoImpl extends AbstractGenericDao<Game, Long> implements GameDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        return Database.getInstance();
    }
}
