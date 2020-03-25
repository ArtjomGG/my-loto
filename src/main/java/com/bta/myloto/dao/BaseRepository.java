package com.bta.myloto.dao;

public interface BaseRepository<E> {
    int saveOrUpdate(E entity);
}
