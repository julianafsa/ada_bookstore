package br.com.ada.bookstore.database;

import br.com.ada.bookstore.model.Inventory;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.model.enumerations.Category;

import java.util.*;

public class InventoryDatabase implements AbstractDatabase<Inventory, Long> {
    private static InventoryDatabase instance;
    private final Map<Category, List<Inventory>> map;
    private Class<?> entityClass;

    private InventoryDatabase() {
        map = new HashMap<>();
        Category[] categories = Category.values();
        for (Category category: categories) {
            map.put(category, new ArrayList<>());
        }
    }

    public static InventoryDatabase getInstance () {
        if (instance == null) {
            instance = new InventoryDatabase();
        }
        return instance;
    }

    @Override
    public void save(Inventory entity) {
        Product product = entity.getProduct();
        if (product != null) {
            String categoryName = product.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            Inventory inventory = list.stream().filter(i -> Objects.equals(product.getId(),
                    i.getProduct().getId())).findFirst().orElse(null);
            if (inventory != null) {
                inventory.addAmount(entity.getAmount());
            } else {
                List<Inventory> actualList = map.get(category);
                inventory = new Inventory(product, 0);
                actualList.add(inventory);
                map.put(category, actualList);
            }
        }
    }

    @Override
    public void update(Inventory entity) {
        Product product = entity.getProduct();
        if (product != null) {
            String categoryName = product.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            Inventory inventory =
                    list.stream().filter(i -> Objects.equals(product.getId(),
                            i.getProduct().getId())).findFirst().orElse(null);
            if (inventory != null) {
                inventory.setAmount(entity.getAmount());
            } else {
                List<Inventory> actualList = new ArrayList<>();
                inventory = new Inventory(product, 0);
                actualList.add(inventory);
                map.put(category, actualList);
            }
        }
    }

    @Override
    public Inventory findById(Long id) {
        Inventory inventory = null;
        List<Inventory> list = this.findAll();
        for (Inventory inv : list) {
            Product product = inv.getProduct();
            if (product.getId().equals(id)) {
                inventory = inv;
            }
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
        Inventory inventory = this.findById(id);
        Product foundedProduct = (inventory != null ? inventory.getProduct() : null);
        if (foundedProduct != null) {
            String categoryName = foundedProduct.getClass().getSimpleName();
            Category category = Category.fromName(categoryName);
            List<Inventory> list = map.get(category);
            Inventory inv =
                    list.stream().filter(i -> Objects.equals(foundedProduct.getId(),
                            i.getProduct().getId())).findFirst().orElse(null);
            if (inv != null) {
                list.remove(inv);
                map.remove(category);
                map.put(category, list);
            }
        }
    }

    @Override
    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Class<?> getEntityClass() {
        return entityClass;
    }

    public List<Inventory> findByCategory(Category category) {
        List<Inventory> inventories = map.get(category);
        return Collections.unmodifiableList(inventories);
    }

}
