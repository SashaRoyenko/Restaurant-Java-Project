package com.robosh.model.dao.mapper;

import com.robosh.model.entity.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements Mapper<Order> {
    Connection connection;

    public OrderMapper(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Order extractObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = Order.newBuilder()
                .setId(resultSet.getLong("order_id"))
                .setUser(new UserMapper().extractObjectFromResultSet(resultSet))
                .setAddress(resultSet.getString("address"))
                .setDate(resultSet.getDate("date"))
                .setBill(resultSet.getFloat("bill"))
                .setPaid(resultSet.getBoolean("paid"))
                .build();
        return order;
    }
}
