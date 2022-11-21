package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.InventoryDao;
import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.InventoryService;

public class InventoryServiceImpl extends AbstractCrudServiceImpl<Inventory, Long> implements InventoryService {
    public InventoryServiceImpl(InventoryDao dao) {
        super(dao);
    }
}
