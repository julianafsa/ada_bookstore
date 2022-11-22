package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.InventoryDao;
import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.model.enumerations.Category;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.InventoryService;

import java.util.List;

public class InventoryServiceImpl extends AbstractCrudServiceImpl<Inventory, Long> implements InventoryService {
    private InventoryDao dao;

    public InventoryServiceImpl(InventoryDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Inventory> findByCategory(Category category) {
        return dao.findByCategory(category);
    }

    public void increaseAmount(final Product product, final Integer amount) {
        dao.increaseAmount(product, amount);
    }

    @Override
    public void decreaseAmount(Product product, Integer amount) {
        dao.decreaseAmount(product, amount);
    }
}
