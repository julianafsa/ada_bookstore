package br.com.ada.bookstore.service;

import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.enumerations.Category;

import java.util.List;

public interface InventoryService extends CrudService<Inventory, Long> {

    List<Inventory> findByCategory(Category category);
}