package br.com.ada.bookstore.database;

import br.com.ada.bookstore.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrderDatabase implements AbstractDatabase<Order, Long> {
    private static OrderDatabase instance;
    private final List<Order> list = new ArrayList<>();
    private static Long id = 0L;
    private Class<?> entityClass;

    private OrderDatabase() {
    }

    public static OrderDatabase getInstance () {
        if (instance == null) {
            instance = new OrderDatabase();
        }
        return instance;
    }

    @Override
    public void save(Order entity) {
        entity.setId(++id);
        list.add(entity);
    }

    @Override
    public void update(Order entity) {
        Order foundedItem = this.findById(entity.getId());
        if (foundedItem != null) {
            int index = list.indexOf(foundedItem);
            list.add(index, entity);
            list.remove(index+1);
        }
    }

    @Override
    public Order findById(Long id) {
        return list.stream().filter(
                o -> Objects.equals(id, o.getId())).findFirst().orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public void remove(Long id) {
        Order order = this.findById(id);
    }

    @Override
    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Class<?> getEntityClass() {
        return entityClass;
    }
}
