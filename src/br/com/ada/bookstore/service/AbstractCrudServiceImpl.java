package br.com.ada.bookstore.service;

import br.com.ada.bookstore.dao.GenericDao;

import java.util.List;

public abstract class AbstractCrudServiceImpl<T, K> implements CrudService<T, K> {

    private final GenericDao<T, K> dao;
    
    public AbstractCrudServiceImpl(GenericDao<T, K> dao) {
        this.dao = dao;
    }

    @Override
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public T findById(K id) {
        return dao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public void remove(K id) {
        dao.remove(id);
    }
}
