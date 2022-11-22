package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.OrderDao;
import br.com.ada.bookstore.dao.impl.InventoryDaoImpl;
import br.com.ada.bookstore.model.Item;
import br.com.ada.bookstore.model.Order;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.InventoryService;
import br.com.ada.bookstore.service.OrderService;

import java.util.List;

public class OrderServiceImpl extends AbstractCrudServiceImpl<Order, Long> implements OrderService {
    public OrderServiceImpl(OrderDao dao) {
        super(dao);
    }

    private InventoryService inventoryService = new InventoryServiceImpl(new InventoryDaoImpl());

    @Override
    public void save(final Order entity) {
        super.save(entity);
        final List<Item> items = entity.getItens();
        for (Item item: items) {
            inventoryService.decreaseAmount(item.getProduct(), item.getAmount());
        }
    }

    @Override
    public void update(Order entity) {
        super.update(entity);
        this.remove(entity.getId());
        this.save(entity);
    }

    @Override
    public void remove(final Long id) {
        super.remove(id);
        Order order = this.findById(id);
        final List<Item> items = order.getItens();
        for (Item item: items) {
            inventoryService.increaseAmount(item.getProduct(), item.getAmount());
        }
    }
}
