package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.BookDao;
import br.com.ada.bookstore.model.Book;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.BookService;

public class BookServiceImpl extends AbstractCrudServiceImpl<Book, Long> implements BookService {
    public BookServiceImpl(BookDao dao) {
        super(dao);
    }
}
