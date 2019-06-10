package com.robosh.model.dao;

import com.robosh.model.entity.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    boolean isPaid(Order order);
    List<Order> getUserUnpaidOrders(long user_id);
    List<Order> getPaidOrders();
    List<Order> getUncheckedOrders();
    void changePaymentStatus(long id);
    void confirmOrder(long id);
}
