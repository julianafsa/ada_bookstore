package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.ProductDao;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.ProductService;

public class ProductServiceImpl  extends AbstractCrudServiceImpl<Product, Long> implements ProductService {
    public ProductServiceImpl(ProductDao dao) {
        super(dao);
    }
}
