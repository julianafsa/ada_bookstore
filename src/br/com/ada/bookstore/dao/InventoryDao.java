package br.com.ada.bookstore.dao;

import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.model.enumerations.Category;

import java.util.List;

public interface InventoryDao extends GenericDao<Inventory, Long> {

    List<Inventory> findByCategory(final Category category);
    void increaseAmount(final Product product, final Integer amount);
    void decreaseAmount(final Product product, final Integer amount);
}
