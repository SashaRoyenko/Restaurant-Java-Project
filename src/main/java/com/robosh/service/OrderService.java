package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderDao;
import com.robosh.model.entity.Order;

public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void createOrder(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {

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
