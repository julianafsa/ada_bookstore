package br.com.ada.bookstore.database;

import br.com.ada.bookstore.dao.impl.ProductDaoImpl;
import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.model.enumerations.Category;
import br.com.ada.bookstore.service.ProductService;
import br.com.ada.bookstore.service.impl.ProductServiceImpl;

import java.util.*;

public class InventoryDatabase implements AbstractDatabase<Inventory, Long> {
    private static InventoryDatabase instance;
    private final Map<Category, List<Inventory>> map;
    private Class entityClass;
    private final ProductService productService;

    private InventoryDatabase() {
        map = new HashMap<>();
        Category[] categories = Category.values();
        for (Category category: categories) {
            map.put(category, new ArrayList<>());
        }
        productService = new ProductServiceImpl(new ProductDaoImpl());
    }

    public static InventoryDatabase getInstance () {
        if (instance == null) {
            instance = new InventoryDatabase();
        }
        return instance;
    }

    @Override
    public void save(Inventory entity) {
        Long productId = entity.getProductId();
        Product foundedProduct = productService.findById(productId);
        if (foundedProduct != null) {
            String categoryName = foundedProduct.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            Inventory inventory =
                    list.stream().filter(i -> Objects.equals(foundedProduct.getId(),
                            i.getProductId())).findFirst().orElse(null);
            if (inventory != null) {
                inventory.addAmount(entity.getAmount());
            } else {
                List<Inventory> actualList = map.get(category);
                actualList.add(inventory);
                map.put(category, actualList);
            }
        }
    }

    @Override
    public void update(Inventory entity) {
        Long productId = entity.getProductId();
        Product foundedProduct = productService.findById(productId);
        if (foundedProduct != null) {
            String categoryName = foundedProduct.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            Inventory inventory =
                    list.stream().filter(i -> Objects.equals(foundedProduct.getId(),
                            i.getProductId())).findFirst().orElse(null);
            if (inventory != null) {
                inventory.setAmount(entity.getAmount());
            } else {
                List<Inventory> actualList = new ArrayList<>();
                actualList.add(inventory);
                map.put(category, actualList);
            }
        }
    }

    @Override
    public Inventory findById(Long id) {
        Inventory inventory = null;
        Product foundedProduct = productService.findById(id);
        if (foundedProduct != null) {
            String categoryName = foundedProduct.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            inventory = list.stream().filter(i -> Objects.equals(foundedProduct.getId(),
                    i.getProductId())).findFirst().orElse(null);
        }
        return inventory;
    }

    @Override
    public List<Inventory> findAll() {
        List<Inventory> list = new ArrayList<>();
        for (Map.Entry<Category, List<Inventory>> entry : map.entrySet()) {
            list.addAll(entry.getValue());
        }
        return list;
    }

    @Override
    public void remove(Long id) {
        Product foundedProduct = productService.findById(id);
        if (foundedProduct != null) {
            String categoryName = foundedProduct.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            Inventory inventory =
                    list.stream().filter(i -> Objects.equals(foundedProduct.getId(),
                            i.getProductId())).findFirst().orElse(null);
            if (inventory != null) {
                list.remove(inventory);
                map.remove(category);
                map.put(category, list);
            }
        }
    }

    @Override
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Class getEntityClass() {
        return entityClass;
    }

}
