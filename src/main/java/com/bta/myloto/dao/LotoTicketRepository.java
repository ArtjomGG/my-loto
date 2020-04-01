package com.bta.myloto.dao;

import com.bta.myloto.domain.LotoTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LotoTicketRepository implements BaseRepository<LotoTicket>{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int saveOrUpdate(LotoTicket entity) {

        String sql = "insert into my_loto_tickets (" +
                "my_lotto_results_id, " + //forigne key
                "user_account_id, " + //forigne key
                "number1, " +
                "number2, " +
                "number3, " +
                "number4, " +
                "number5, " +
                "number6) " +
                "values (:myLotoResultsId, :userAccountId,:number1, :number2, :number3, :number4, :number5, :number6)";

        MapSqlParameterSource map = new MapSqlParameterSource();

        map.addValue("myLotoResultsId", entity.getResultId());
        map.addValue("userAccountId", entity.getUserAccountId());
        map.addValue("number1", entity.getMyTicketNum1());
        map.addValue("number2", entity.getMyTicketNum2());
        map.addValue("number3", entity.getMyTicketNum3());
        map.addValue("number4", entity.getMyTicketNum4());
        map.addValue("number5", entity.getMyTicketNum5());
        map.addValue("number6", entity.getMyTicketNum6());

        return namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public Integer delete(LotoTicket entity) {
        return null;
    }
}
