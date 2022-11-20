package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.GameDao;
import br.com.ada.bookstore.model.Game;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.GameService;

public class GameServiceImpl extends AbstractCrudServiceImpl<Game, Long> implements GameService {
    public GameServiceImpl(GameDao dao) {
        super(dao);
    }
}
