package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderProductsDao;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Class OrderProductsService
 * realise logic manipulation
 * with db for class OrderProducts
 *
 * @author Sasha
 */
public class OrderProductsService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * This method is create new order products in db for certain user
     *
     * @param user
     */
    public void createOrderProductsWithUSer(User user) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.createOrderProductsWithUser(user);
        }

    }

    /**
     * This method is create new order products in db
     *
     * @param orderProducts
     */
    public void createOrderProducts(OrderProducts orderProducts) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.create(orderProducts);
        }

    }

    /**
     * This method is used to get order products from db by it's id
     *
     * @param id
     * @return OrderProducts
     */
    public OrderProducts getOrderProductsById(long id) {
        OrderProducts OrderProducts;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            OrderProducts = dao.findById(id);
        }
        return OrderProducts;
    }

    /**
     * This method is used to get order products from db for certain user
     *
     * @param user
     * @return OrderProducts
     */
    public OrderProducts getOrderProductsByUser(User user) {
        OrderProducts OrderProducts;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            OrderProducts = dao.findOrderProductsByUser(user);
        }
        return OrderProducts;
    }

    /**
     * This method return all orders from db
     *
     * @return List<OrderProducts>
     */
    public List<OrderProducts> getAllOrderProducts() {
        List<OrderProducts> orderProductsList;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            orderProductsList = dao.findAll();
        }
        return orderProductsList;
    }

    /**
     * This method add dish into certain order products
     *
     * @param dish
     * @param orderProducts
     */
    public void addDish(Dish dish, OrderProducts orderProducts) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.addDish(dish, orderProducts);
        }
    }

    /**
     * This method add drink into certain order products
     *
     * @param drink
     * @param orderProducts
     */
    public void addDrink(Drink drink, OrderProducts orderProducts) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.addDrink(drink, orderProducts);
        }
    }

    /**
     * This method delete dish from certain order products
     *
     * @param dish
     * @param orderProducts
     */
    public void deleteDish(Dish dish, OrderProducts orderProducts) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.deleteDish(dish, orderProducts);
        }
    }

    /**
     * This method delete drink from certain order products
     *
     * @param drink
     * @param orderProducts
     */
    public void deleteDrink(Drink drink, OrderProducts orderProducts) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.deleteDrink(drink, orderProducts);
        }
    }

    /**
     * This method return all drinks for certain user
     *
     * @param user
     * @return List<Drink>
     */
    public List<Drink> selectDrinks(User user) {
        List<Drink> drinks;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            drinks = dao.selectDrinks(user);
        }
        return drinks;
    }

    /**
     * This method return all dishes for certain user
     *
     * @param user
     * @return List<Dish>
     */
    public List<Dish> selectDishes(User user) {
        List<Dish> dishes;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dishes = dao.selectDishes(user);
        }
        return dishes;
    }

    /**
     * This method return price of all products for certain user
     *
     * @param user
     * @return float
     */
    public float getTotalPrice(User user) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            return dao.getTotalDishPrice(user) + dao.getTotalDrinkPrice(user);
        }
    }

    /**
     * This method delete order products for certain user id
     *
     * @param id
     */
    public void deleteOrderProductsForUserId(long id) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if such order products is exist
     *
     * @param id
     * @return boolean
     */
    public boolean isOrderProductsExist(long id) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            return dao.isOrderProductsExist(id);
        }
    }
}
