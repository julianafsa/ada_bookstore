package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.MovieDao;
import br.com.ada.bookstore.model.Movie;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.MovieService;

public class MovieServiceImpl extends AbstractCrudServiceImpl<Movie, Long> implements MovieService {
    public MovieServiceImpl(MovieDao dao) {
        super(dao);
    }
}
