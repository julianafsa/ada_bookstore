package br.com.ada.bookstore.service.impl;

import br.com.ada.bookstore.dao.CashManagerDao;
import br.com.ada.bookstore.service.CashManagerService;

import java.math.BigDecimal;

public class CashManagerServiceImpl implements CashManagerService {

    private CashManagerDao dao;
    public CashManagerServiceImpl(CashManagerDao dao) {
        this.dao = dao;
    }

    @Override
    public void addBalance(BigDecimal balance) {
        dao.addBalance(balance);
    }

    @Override
    public void reduceBalance(BigDecimal balance) {
        dao.reduceBalance(balance);
    }
}
