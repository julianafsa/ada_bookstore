package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.OrderDao;
import br.com.ada.bookstore.dao.impl.CashManagerDaoImpl;
import br.com.ada.bookstore.dao.impl.InventoryDaoImpl;
import br.com.ada.bookstore.model.Book;
import br.com.ada.bookstore.model.Item;
import br.com.ada.bookstore.model.Order;
import br.com.ada.bookstore.model.Product;
import br.com.ada.bookstore.model.customer.Customer;
import br.com.ada.bookstore.service.AbstractCrudServiceImpl;
import br.com.ada.bookstore.service.CashManagerService;
import br.com.ada.bookstore.service.InventoryService;
import br.com.ada.bookstore.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class OrderServiceImpl extends AbstractCrudServiceImpl<Order, Long> implements OrderService {
    public OrderServiceImpl(OrderDao dao) {
        super(dao);
    }

    private InventoryService inventoryService = new InventoryServiceImpl(new InventoryDaoImpl());
    private CashManagerService cashManagerService = new CashManagerServiceImpl(new CashManagerDaoImpl());
    private final BigDecimal DISCOUNT_FROM = new BigDecimal("200");
    private final BigDecimal PERCENTAGEM_DISCOUNT = new BigDecimal("0.15");

    @Override
    public void save(Order entity) {
        final Customer customer = entity.getCustomer();
        if (customer != null) {
            final Boolean hasMininumAge = this.hasMinimumAge(customer);
            final List<Item> items = entity.getItens();
            for (Item item: items) {
                final Product product = item.getProduct();
                if (product.hasAdultAudience() && !hasMininumAge) {
                    throw new RuntimeException("You can not order the product " + product);
                }
            }
        }
        this.save2(entity);
    }

    private void save2(final Order entity) {
        super.save(entity);
        final List<Item> items = entity.getItens();
        Boolean hasBook = Boolean.FALSE;
        BigDecimal totalBookCost = new BigDecimal("0");
        for (Item item: items) {
            final Product product = item.getProduct();
            inventoryService.decreaseAmount(product, item.getAmount());
            // TODO Changing
            if (product instanceof Book) {
                hasBook = Boolean.TRUE;
                totalBookCost = totalBookCost.add(product.getPrice().multiply(new BigDecimal(item.getAmount())));
            }
        }
        BigDecimal totalOrderValue = entity.getTotalOrderValue();
        System.out.println("Total: " + totalOrderValue);
        if (hasBook) {
            if (totalBookCost.compareTo(DISCOUNT_FROM) > 0) {
                final BigDecimal discount = totalBookCost.multiply(PERCENTAGEM_DISCOUNT);
                System.out.println("Discount: " + discount);
                totalOrderValue = totalOrderValue.subtract(discount);
            }
        }
        System.out.println("Total with discount: " + totalOrderValue);
        cashManagerService.addBalance(totalOrderValue);
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
        final Order order = this.findById(id);
        final List<Item> items = order.getItens();
        for (Item item: items) {
            inventoryService.increaseAmount(item.getProduct(), item.getAmount());
        }
        cashManagerService.reduceBalance(order.getTotalOrderValue());
    }

    private Boolean hasMinimumAge(Customer customer) {
        final Integer minimumAge = 18;
        final LocalDate birthdate = customer.getBirthdate();
        final LocalDate now = LocalDate.now();
        final Period period = Period.between(birthdate, now);
        final Integer age = period.getYears();
        if (age >= minimumAge)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

}
