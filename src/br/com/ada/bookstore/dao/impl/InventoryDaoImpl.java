package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.InventoryDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.InventoryDatabase;
import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.enumerations.Category;

import java.util.List;

public class InventoryDaoImpl extends AbstractGenericDao<Inventory, Long> implements InventoryDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        InventoryDatabase database = InventoryDatabase.getInstance();
        database.setEntityClass(Inventory.class);
        return database;
    }

    @Override
    public List<Inventory> findByCategory(Category category) {
        InventoryDatabase database = InventoryDatabase.getInstance();
        return database.findByCategory(category);
    }
}
