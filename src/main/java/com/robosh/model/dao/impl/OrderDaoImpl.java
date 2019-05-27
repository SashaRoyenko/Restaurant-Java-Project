package com.robosh.model.dao.impl;

import com.robosh.model.dao.OrderDao;
import com.robosh.model.dao.impl.SqlQueries.OrderSqlQueries;
import com.robosh.model.dao.mapper.OrderMapper;
import com.robosh.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private Connection connection;

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Order entity) throws SQLException {
        final String query = OrderSqlQueries.CREATE_ORDER.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(2, entity.getAddress());
        preparedStatement.setLong(2, entity.getUser().getId());
        preparedStatement.execute();
    }

    @Override
    public Order findById(long id) throws SQLException {
        OrderMapper orderMapper = new OrderMapper(connection);
        Order order = new Order();
        String query = OrderSqlQueries.FIND_ORDER_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        final ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            order = orderMapper.extractObjectFromResultSet(resultSet);
        }
        return order;
    }

    @Override
    public List<Order> findAll() throws SQLException {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.FIND_ALL_ORDERS.getQuery();
        Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()) {
            orders.add(orderMapper.extractObjectFromResultSet(resultSet));
        }
        return orders;
    }

    @Override
    public void update(Order order) throws SQLException {
        final String query = OrderSqlQueries.DELETE_ORDER.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, order.getId());
        preparedStatement.executeQuery();
    }

    @Override
    public void delete(long id) throws SQLException {

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
    public boolean isPaid(Order order) throws SQLException {
        String query = OrderSqlQueries.GET_PAID_STATUS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, order.getId());
        final ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getBoolean("paid");
    }

    @Override
    public void changePaymentStatus(Order order, boolean status) throws SQLException {
        final String query = OrderSqlQueries.UPDATE_PAID_STATUS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setBoolean(1, status);
        preparedStatement.setLong(2, order.getId());
        preparedStatement.executeQuery();
    }
}
