package com.robosh.model.dao;

import com.robosh.model.entity.Order;

public interface OrderDao extends Dao<Order> {
    boolean isPaid(Order order);

    void changePaymentStatus(Order order, boolean status);
}
