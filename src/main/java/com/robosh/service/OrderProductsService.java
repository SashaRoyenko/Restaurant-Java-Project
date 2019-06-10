package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderProductsDao;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public class OrderProductsService {
    private DaoFactory daoFactory = DaoFactory.getInstance();


    public void createOrderProductsWithUSer(User user) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.createOrderProductsWithUser(user);
        }

    }

    public void createOrderProducts(OrderProducts orderProducts) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            dao.create(orderProducts);
        }

    }

    public OrderProducts getOrderProductsById(long id) {
        OrderProducts OrderProducts;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            OrderProducts = dao.findById(id);
        }
        return OrderProducts;
    }
    public OrderProducts getOrderProductsByUser(User user) {
        OrderProducts OrderProducts;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()) {
            OrderProducts = dao.findOrderProductsByUser(user);
        }
        return OrderProducts;
    }

    public List<OrderProducts> getAllOrderProductses() {
        List<OrderProducts> orderProductsList;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            orderProductsList = dao.findAll();
        }
        return orderProductsList;
    }

    public void addDish(Dish dish, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
           dao.addDish(dish, orderProducts);
        }
    }
    public void addDrink(Drink drink, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.addDrink(drink, orderProducts);
        }
    }
    public void deleteDish(Dish dish, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.deleteDish(dish, orderProducts);
        }
    }
    public void deleteDrink(Drink drink, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.deleteDrink(drink, orderProducts);
        }
    }
    public List<Drink> selectDrinks(User user){
        List<Drink> drinks;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            drinks = dao.selectDrinks(user);
        }
        return drinks;
    }
    public List<Dish> selectDishes(User user){
        List<Dish> dishes;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dishes = dao.selectDishes(user);
        }
        return dishes;
    }
    public float getTotalPrice(User user){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            return dao.getTotalDishPrice(user) + dao.getTotalDrinkPrice(user);
        }
    }

    public void deleteOrderProductsForUserId(long id) {
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
