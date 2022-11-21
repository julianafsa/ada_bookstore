package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.BookDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.ProductDatabase;
import br.com.ada.bookstore.model.Book;

public class BookDaoImpl extends AbstractGenericDao<Book, Long> implements BookDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        productDatabase.setEntityClass(Book.class);
        return productDatabase;
    }
}
