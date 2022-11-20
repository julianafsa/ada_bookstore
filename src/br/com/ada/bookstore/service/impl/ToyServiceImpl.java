package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.ToyDao;
import br.com.ada.bookstore.model.Toy;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.ToyService;

public class ToyServiceImpl extends AbstractCrudServiceImpl<Toy, Long> implements ToyService {
    public ToyServiceImpl(ToyDao dao) {
        super(dao);
    }
}
