package com.bta.myloto.dao;

import com.bta.myloto.domain.BaseEntenty;

public interface BaseRepository<E extends BaseEntenty> {
    int saveOrUpdate(E entity);
    Integer delete (E entity);

}
