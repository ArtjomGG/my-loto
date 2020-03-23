package com.bta.myloto.dao;

import com.bta.myloto.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDao implements Dao<UserAccount> {

    @Autowired
    private JdbcTemplate jdbcTemplate; //skr6vat vs

    @Override
    public int saveOrUpdate(UserAccount entity) {
        return jdbcTemplate.update("insert into user_account (userName, firstName, lastName, isikuKood, email) values (?, ?, ?, ?, ?)",
                entity.getUserName(), entity.getFirstName(), entity.getLastName(), entity.getIsikuKood(), entity.getEmail());
    }
}
