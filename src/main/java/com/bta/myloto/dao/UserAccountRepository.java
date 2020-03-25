package com.bta.myloto.dao;

import com.bta.myloto.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public UserAccount findUserAccountByUserName (String userName) {

        String sql = "select * from user_account where userName = :userName";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("userName", userName);

        RowMapper <UserAccount> mapper = (resultSet, i) -> { // BiFunction: prinimaet dva parametra (resultSet, i) vozvrashaet user-a
            UserAccount userForMapper = new UserAccount();
            userForMapper.setId(resultSet.getLong("id"));
            userForMapper.setUserName(resultSet.getString("userName"));
            userForMapper.setUserPassword(resultSet.getString("userPassword"));
            userForMapper.setFirstName(resultSet.getString("firstName"));
            userForMapper.setLastName(resultSet.getString("lastName"));
            userForMapper.setIsikuKood(resultSet.getLong("isikuKood"));
            userForMapper.setEmail(resultSet.getString("email"));

            return userForMapper;
        };

        return namedParameterJdbcTemplate.queryForObject(sql,map, mapper);

    }

}
