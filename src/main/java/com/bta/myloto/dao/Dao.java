package com.bta.myloto.dao;

public interface Dao<E> {
    int saveOrUpdate(E entity);
}
