package com.robosh.model.dao.impl;

import com.robosh.model.dao.OrderProductsDao;
import com.robosh.model.dao.impl.SqlQueries.OrderProductsQueries;
import com.robosh.model.dao.mapper.OrderProductsMapper;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderProductsDaoImpl implements OrderProductsDao {
    private Connection connection;

    public OrderProductsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(OrderProducts entity) throws SQLException {
        final String query = OrderProductsQueries.CREATE_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, entity.getUser().getId());
        preparedStatement.execute();
    }

    @Override
    public OrderProducts findById(long id) throws SQLException {
        OrderProducts orderProducts = new OrderProducts();
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        String query = OrderProductsQueries.FIND_ORDER_PRODUCTS_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        final ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            orderProducts = orderProductsMapper.extractObjectFromResultSet(resultSet);
        }
        return orderProducts;
    }

    @Override
    public List<OrderProducts> findAll() throws SQLException {
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        List<OrderProducts> orderProducts = new ArrayList<>();
        Statement statement = connection.createStatement();
        final String query = OrderProductsQueries.FIND_ALL_ORDER_PRODUCTS.getQuery();
        final ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            orderProducts.add(orderProductsMapper.extractObjectFromResultSet(resultSet));
        }
        return orderProducts;
    }

    @Override
    public void update(OrderProducts orderProducts) throws SQLException {

    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = OrderProductsQueries.DELETE_ORDER_PRODUCTS.getQuery();
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

    @Override
    public void addDish(Dish dish, OrderProducts orderProducts) throws SQLException {
        final String query = OrderProductsQueries.ADD_DISH_TO_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, dish.getId());
        preparedStatement.setLong(1, orderProducts.getId());
        preparedStatement.execute();
    }

    @Override
    public void addDrink(Drink drink, OrderProducts orderProducts) throws SQLException {
        final String query = OrderProductsQueries.ADD_DRINK_TO_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, drink.getId());
        preparedStatement.setLong(1, orderProducts.getId());
        preparedStatement.execute();
    }

    @Override
    public void deleteDish(Dish dish, OrderProducts orderProducts) throws SQLException {
        final String query = OrderProductsQueries.DELETE_DISH_FROM_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, dish.getId());
        preparedStatement.setLong(2, orderProducts.getId());
        preparedStatement.executeQuery();
    }

    @Override
    public void deleteDrink(Drink drink, OrderProducts orderProducts) throws SQLException {
        final String query = OrderProductsQueries. DELETE_DRINK_FROM_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, drink.getId());
        preparedStatement.setLong(2, orderProducts.getId());
        preparedStatement.executeQuery();
    }

    @Override
    public List<Drink> selectDrinks(User user) throws SQLException {
        List<Drink> drinkList;
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        final String query = OrderProductsQueries.SELECT_DRINKS_FROM_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, user.getId());
        final ResultSet resultSet = preparedStatement.executeQuery();
        drinkList = orderProductsMapper.extractOrderProductsDrinks(resultSet);
        return drinkList;
    }

    @Override
    public List<Dish> selectDishes(User user) throws SQLException {
        List<Dish> dishList;
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        final String query = OrderProductsQueries.SELECT_DISHES_FROM_ORDER_PRODUCTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, user.getId());
        final ResultSet resultSet = preparedStatement.executeQuery();
        dishList = orderProductsMapper.extractOrderProductsDishes(resultSet);
        return dishList;
    }
}
