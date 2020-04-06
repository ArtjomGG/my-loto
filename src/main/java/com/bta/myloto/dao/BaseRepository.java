package com.bta.myloto.dao;

import com.bta.myloto.domain.BaseEntenty;

import java.util.List;

public interface BaseRepository<E extends BaseEntenty> {
    int saveOrUpdate(E entity);
    Integer delete (E entity);
    List<E> findAll(E entity);
}
