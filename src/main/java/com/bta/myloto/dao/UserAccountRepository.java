package com.bta.myloto.dao;

import com.bta.myloto.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Onvechaet to chto budet sozdan BEAN v Contekste
public class UserAccountRepository implements BaseRepository<UserAccount> {

    @Autowired
    private JdbcTemplate jdbcTemplate; //skr6vat vs

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate; //

    @Override
    public int saveOrUpdate(UserAccount entity) { // ne moshet b6t' static
        return jdbcTemplate.update("insert into user_account (userName, " +
                        "userPassword, " +
                        "firstName, " +
                        "lastName, " +
                        "isikuKood, " +
                        "email) " +
                        "values (?, ?, ?, ?, ?, ?)",
                entity.getUserName(),
                entity.getUserPassword(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getIsikuKood(),
                entity.getEmail());
    }

    @Override
    public Integer delete(UserAccount ententy) {
        String sql = "delete from user_account where userName = :userName";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userName", ententy.getUserName());
        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource);

    }


    public List<UserAccount> findUserAccountByUserName (String userName) {

        String sql = "select * from user_account where userName = :userName";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("userName", userName);

    // BiFunction: prinimaet dva parametra (resultSet, i) vozvrashaet user-a
        return namedParameterJdbcTemplate.query(sql, map, (resultSet, i) ->
                new UserAccount(resultSet.getLong("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("userPassword"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getLong("isikuKood"),
                        resultSet.getString("email")
                ));

    }

}
