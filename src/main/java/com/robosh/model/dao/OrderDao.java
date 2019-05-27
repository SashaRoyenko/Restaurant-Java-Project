package com.robosh.model.dao;

import com.robosh.model.entity.Order;

import java.sql.SQLException;

public interface OrderDao extends Dao<Order> {
    boolean isPaid(Order order) throws SQLException;

    void changePaymentStatus(Order order, boolean status) throws SQLException;
}
