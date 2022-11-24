package br.com.ada.bookstore.database;

import br.com.ada.bookstore.model.CashRegister;
import br.com.ada.bookstore.model.QuantityManager;

import java.math.BigDecimal;

public class CashManagerDatabase implements QuantityManager<BigDecimal> {
    private static CashManagerDatabase instance;
    private CashRegister cashRegister;

    private CashManagerDatabase() {
        cashRegister = new CashRegister(new BigDecimal("0"));
    }

    public static CashManagerDatabase getInstance () {
        if (instance == null) {
            instance = new CashManagerDatabase();
        }
        return instance;
    }

    public void addBalance(BigDecimal balance) {
        cashRegister.addBalance(balance);
    }

    public void reduceBalance(BigDecimal balance) {
        cashRegister.reduceBalance(balance);
    }

    public BigDecimal getBalance() {
        return cashRegister.getBalance();
    }

}
