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
        return jdbcTemplate.update("insert into user_account (" +
                        "username, " +
                        "password, " +
                        "firstName, " +
                        "lastName, " +
                        "isikuKood, " +
                        "email," +
                        "active," +
                        "role) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)",
                entity.getUsername(),
                entity.getPassword(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getIsikuKood(),
                entity.getEmail(),
                entity.isActive(),
                entity.getRole());
    }

    @Override
    public Integer delete(UserAccount ententy) {
        String sql = "delete from user_account where username = :username";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("username", ententy.getUsername());

        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource);
    }

    @Override
    public List<UserAccount> findAll(UserAccount entity) {
        return null;
    }


    public List<UserAccount> findUserAccountByUserName (String username) {

        String sql = "select * from user_account where username = :username";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("username", username);

    // BiFunction: prinimaet dva parametra (resultSet, i) vozvrashaet user-a
        return namedParameterJdbcTemplate.query(sql, map, (resultSet, i) ->
                new UserAccount(resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getLong("isikuKood"),
                        resultSet.getBoolean("active"),
                        resultSet.getString("role"),
                        resultSet.getString("email")
                ));
    }
}
