package com.robosh.model.dao.impl;

import com.robosh.model.dao.DrinkDao;
import com.robosh.model.dao.impl.SqlQueries.DrinkSqlQueries;
import com.robosh.model.dao.mapper.DrinkMapper;
import com.robosh.model.entity.Drink;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinkDaoImpl implements DrinkDao {
    private Connection connection;

    public DrinkDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Drink entity) throws SQLException {
        final String query = DrinkSqlQueries.CREATE_DRINK.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setFloat(2, entity.getVolume());
        preparedStatement.setFloat(3, entity.getPrice());
        preparedStatement.execute();
    }

    @Override
    public Drink findById(long id) throws SQLException {
        Drink drink = new Drink();
        DrinkMapper drinkMapper = new DrinkMapper();
        final String query = DrinkSqlQueries.FIND_DRINK_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.executeQuery();
        final ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            drink = drinkMapper.extractObjectFromResultSet(resultSet);
        }
        return drink;
    }

    @Override
    public List<Drink> findAll() throws SQLException {
        DrinkMapper drinkMapper = new DrinkMapper();
        List<Drink> drinkList = new ArrayList<>();
        Statement statement = connection.createStatement();
        final String query = DrinkSqlQueries.FIND_ALL_DRINKS.getQuery();
        final ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            drinkList.add(drinkMapper.extractObjectFromResultSet(resultSet));
        }
        return drinkList;
    }

    @Override
    public void update(Drink drink) throws SQLException {
        throw new UnsupportedOperationException("This action has not been used here.");
    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = DrinkSqlQueries.DELETE_DRINK.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.executeQuery();
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
