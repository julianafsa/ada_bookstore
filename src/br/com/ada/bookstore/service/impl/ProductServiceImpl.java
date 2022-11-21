package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.ProductDao;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.ProductService;

public class ProductServiceImpl  extends AbstractCrudServiceImpl<Product, Long> implements ProductService {
    //private InventoryService inventoryService = new InventoryServiceImpl(new InventoryDaoImpl());

    public ProductServiceImpl(ProductDao dao) {
        super(dao);
    }

    @Override
    public void save(Product entity) {
        super.save(entity);

//        Inventory inventory = new Inventory(entity.getId(), 0);
//        inventoryService.save(inventory);

    }
}
