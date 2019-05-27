package com.robosh.model.dao.impl;

import com.robosh.model.connection.ConnectionPoolHolder;
import com.robosh.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ImplDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl(getConnection());
    }

    @Override
    public DishDao createDishDao() {
        return new DishDaoImpl(getConnection());
    }

    @Override
    public DrinkDao createDrinkDao() {
        return new DrinkDaoImpl(getConnection());
    }

    @Override
    public IngredientDao createIngredientDao() {
        return new IngredientDaoImpl(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new OrderDaoImpl(getConnection());
    }

    @Override
    public OrderProductsDao createOrderProductsDao() {
        return new OrderProductsDaoImpl(getConnection());
    }

    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
