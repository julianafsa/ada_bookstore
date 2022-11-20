package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.AlbumDao;
import br.com.ada.bookstore.model.Album;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.AlbumService;

public class AlbumServiceImpl extends AbstractCrudServiceImpl<Album, Long> implements AlbumService {
    public AlbumServiceImpl(AlbumDao dao) {
        super(dao);
    }
}
