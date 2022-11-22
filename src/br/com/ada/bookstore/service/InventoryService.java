package br.com.ada.bookstore.service;

import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.model.enumerations.Category;

import java.util.List;

public interface InventoryService extends CrudService<Inventory, Long> {

    List<Inventory> findByCategory(final Category category);
    void increaseAmount(final Product product, final Integer amount);
    void decreaseAmount(final Product product, final Integer amount);
}