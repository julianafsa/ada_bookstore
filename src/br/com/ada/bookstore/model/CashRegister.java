package br.com.ada.bookstore.model;

import java.math.BigDecimal;

public class CashRegister implements QuantityManager<BigDecimal>{
    private BigDecimal balance;

    public CashRegister(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void addBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    @Override
    public void reduceBalance(BigDecimal balance) {
        this.balance = this.balance.subtract(balance);
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "balance=" + balance +
                '}';
    }
}
