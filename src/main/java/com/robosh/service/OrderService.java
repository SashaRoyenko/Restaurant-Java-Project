package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderDao;
import com.robosh.model.entity.Order;

import java.util.List;

public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findAll();
        }
    }

    public List<Order> getPaidOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getPaidOrders();
        }
    }

    public List<Order> geUncheckedOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getUncheckedOrders();
        }
    }

    public List<Order> getUserUnpaidOrders(long user_id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getUserUnpaidOrders(user_id);
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

    public boolean isPaid(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.isPaid(order);
        }
    }

    public void changePaymentStatus(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.changePaymentStatus(id);
        }
    }

    public void confirmOrder(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.confirmOrder(id);
        }
    }

    public List<Order> getPaidOrders(long from, long to) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getPaidOrders(from, to);
        }
    }

    public List<Order> getUncheckedOrders(long from, long to) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getUncheckedOrders(from, to);
        }
    }

    public long getPaidOrderCount() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.paidOrderCount();
        }
    }

    public long getUncheckedOrderCount() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.uncheckedOrderCount();
        }
    }
}
