package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.MovieDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.factory.Database;
import br.com.ada.bookstore.model.Movie;

public class MovieDaoImpl extends AbstractGenericDao<Movie, Long> implements MovieDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        return Database.getInstance();
    }
}
