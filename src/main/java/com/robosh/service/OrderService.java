package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderDao;
import com.robosh.model.entity.Order;

import java.util.List;

public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllOrders(){
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findAll();
        }
    }

    public void createOrder(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.create(order);
        }
    }

    public Order getOrderById(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findById(id);
        }
    }

    boolean isPaid(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.isPaid(order);
        }
    }

    void changePaymentStatus(Order order, boolean status) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.changePaymentStatus(order, status);
        }
    }
}
