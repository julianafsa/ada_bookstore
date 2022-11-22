package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.AbstractGenericDao;
import br.com.ada.bookstore.dao.OrderDao;
import br.com.ada.bookstore.database.AbstractDatabase;
import br.com.ada.bookstore.database.OrderDatabase;
import br.com.ada.bookstore.model.Order;

public class OrderDaoImpl extends AbstractGenericDao<Order, Long> implements OrderDao {
    @Override
    public AbstractDatabase getAbstractDatabase() {
        OrderDatabase database = OrderDatabase.getInstance();
        database.setEntityClass(Order.class);
        return database;
    }
}
