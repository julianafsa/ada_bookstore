package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.AlbumDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.ProductDatabase;
import br.com.ada.bookstore.model.Album;

public class AlbumDaoImpl extends AbstractGenericDao<Album, Long> implements AlbumDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        productDatabase.setEntityClass(Album.class);
        return productDatabase;
    }
}
