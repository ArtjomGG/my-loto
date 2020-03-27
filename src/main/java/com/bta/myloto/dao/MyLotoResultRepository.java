package com.bta.myloto.dao;

import com.bta.myloto.domain.MyLotoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyLotoResultRepository implements BaseRepository<MyLotoResult>{

    @Autowired
    private JdbcTemplate jdbcTemplate; //skr6vat vs

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate; //

    @Override
    public int saveOrUpdate(MyLotoResult entity) {
        return jdbcTemplate.update("insert into my_loto_results (" +
                        "resultsDate, " +
                        "number1, " +
                        "number2, " +
                        "number3, " +
                        "number4, " +
                        "number5, " +
                        "number6) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                entity.getResultsDate(),
                entity.getNumber1(),
                entity.getNumber2(),
                entity.getNumber3(),
                entity.getNumber4(),
                entity.getNumber5(),
                entity.getNumber6());
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }
}
