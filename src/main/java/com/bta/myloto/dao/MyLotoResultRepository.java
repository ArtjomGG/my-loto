package com.bta.myloto.dao;

import com.bta.myloto.domain.MyLotoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyLotoResultRepository implements BaseRepository<MyLotoResult> {

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
    public Integer delete(MyLotoResult entity) {
        String sql = "delete from my_loto_results where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        //mapSqlParameterSource.addValue("id", ententy.getId());
        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource);
    }

    @Override
    public List<MyLotoResult> findAll(MyLotoResult entity) {
        List<MyLotoResult> resultList = new ArrayList<>();
        jdbcTemplate.update("select * from my_loto_results");
        return null;

        /*List<Book> booksList = new ArrayList<>();
        final String sql = "select * from book" ;

        try (Connection connection = DriverManager.getConnection(
                connectionProperties.getProperty("db.url"),
                connectionProperties.getProperty("db.username"),
                connectionProperties.getProperty("db.password"));
             Statement statement = connection.createStatement()) { // uzhe ispolzuem "Statment"

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String bookName = resultSet.getString("name");
                String bookDescr = resultSet.getString("description");
                Long bookId = resultSet.getLong("id");
                Integer bookYear = resultSet.getInt("releas_year");
                booksList.add(new Book(bookId, bookName, bookDescr, bookYear));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booksList;
    }*/

    }
}
