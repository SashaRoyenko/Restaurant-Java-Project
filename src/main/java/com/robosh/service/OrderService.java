package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderDao;
import com.robosh.model.entity.Order;

import java.util.List;

/**
 * Class OrderService
 * realise logic manipulation
 * with db for class Order
 *
 * @author Sasha
 */
public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * This method is used to extract all orders from db.
     *
     * @return List<Order>
     */
    public List<Order> getAllOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findAll();
        }
    }

    /**
     * This method is used to extract all paid orders from db.
     *
     * @return List<Order>
     */
    public List<Order> getPaidOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getPaidOrders();
        }
    }

    /**
     * This method is used to extract all uncheck orders from db.
     *
     * @return List<Order>
     */
    public List<Order> geUncheckedOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getUncheckedOrders();
        }
    }

    /**
     * This method is used to extract all paid orders from db for certain user.
     *
     * @param user_id
     * @return List<Order>
     */
    public List<Order> getUserUnpaidOrders(long user_id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getUserUnpaidOrders(user_id);
        }
    }

    /**
     * This method is used to create new Order in db
     *
     * @param order
     */
    public void createOrder(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.create(order);
        }
    }

    /**
     * This method is used to extract order by certain id.
     *
     * @param id
     * @return Order
     */
    public Order getOrderById(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findById(id);
        }
    }

    /**
     * This method is used to check if order is paid
     *
     * @param order
     * @return boolean
     */
    public boolean isPaid(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.isPaid(order);
        }
    }

    /**
     * This method is used to change payment status in db
     *
     * @param id
     */
    public void changePaymentStatus(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.changePaymentStatus(id);
        }
    }

    /**
     * This method is used to change check status in db
     *
     * @param id
     */
    public void confirmOrder(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.confirmOrder(id);
        }
    }

    /**
     * This method is used to extract paid orders on the gap.
     *
     * @param from
     * @param to
     * @return List<Order>
     */
    public List<Order> getPaidOrders(long from, long to) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getPaidOrders(from, to);
        }
    }

    /**
     * This method is used to extract un check orders on the gap.
     *
     * @param from
     * @param to
     * @return List<Order>
     */
    public List<Order> getUncheckedOrders(long from, long to) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getUncheckedOrders(from, to);
        }
    }

    /**
     * This method is used to get count of paid orders in db
     *
     * @return long
     */
    public long getPaidOrderCount() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.paidOrderCount();
        }
    }

    /**
     * This method is used to get count of uncheck orders in db
     *
     * @return long
     */
    public long getUncheckedOrderCount() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.uncheckedOrderCount();
        }
    }
}
