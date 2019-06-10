package com.robosh.model.dao;

import com.robosh.model.entity.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    boolean isPaid(Order order);
    List<Order> getUserUnpaidOrders(long user_id);
    List<Order> getPaidOrders();
    List<Order> getUncheckedOrders();
    List<Order> getPaidOrders(long from, long to);
    List<Order> getUncheckedOrders(long from, long to);
    void changePaymentStatus(long id);
    void confirmOrder(long id);
    long paidOrderCount();
    long uncheckedOrderCount();

}
