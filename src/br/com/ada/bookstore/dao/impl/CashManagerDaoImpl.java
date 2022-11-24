package br.com.ada.bookstore.dao.impl;

import br.com.ada.bookstore.dao.CashManagerDao;
import br.com.ada.bookstore.database.CashManagerDatabase;

import java.math.BigDecimal;

public class CashManagerDaoImpl implements CashManagerDao {

    private CashManagerDatabase database = CashManagerDatabase.getInstance();

    @Override
    public void addBalance(BigDecimal balance) {
        System.out.print("Updating cash register. Current balance: R$ " + database.getBalance().toString() +
                " Input: +R$ " + balance);
        database.addBalance(balance);
        System.out.println(". New balance: R$ " + database.getBalance().toString() + ".");
    }

    @Override
    public void reduceBalance(BigDecimal balance) {
        System.out.print("Updating cash register. Current balance: R$ " + database.getBalance().toString() +
                " Input: -R$" + balance);
        database.reduceBalance(balance);
        System.out.println(". New balance: R$ " + database.getBalance().toString() + ".");
    }
}
