package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public class CashRegister {
    private BigDecimal balance;

    public CashRegister(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
