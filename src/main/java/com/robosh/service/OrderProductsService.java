package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.OrderProductsDao;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;

import java.util.List;

public class OrderProductsService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

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

    public List<OrderProducts> getAllOrderProductses() {
        List<OrderProducts> orderProductsList;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            orderProductsList = dao.findAll();
        }
        return orderProductsList;
    }

    void addDish(Dish dish, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
           dao.addDish(dish, orderProducts);
        }
    }
    void addDrink(Drink drink, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.addDrink(drink, orderProducts);
        }
    }
    void deleteDish(Dish dish, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.deleteDish(dish, orderProducts);
        }
    }
    void deleteDrink(Drink drink, OrderProducts orderProducts){
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dao.deleteDrink(drink, orderProducts);
        }
    }
    List<Drink> selectDrinks(User user){
        List<Drink> drinks;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            drinks = dao.selectDrinks(user);
        }
        return drinks;
    }
    List<Dish> selectDishes(User user){
        List<Dish> dishes;
        try (OrderProductsDao dao = daoFactory.createOrderProductsDao()){
            dishes = dao.selectDishes(user);
        }
        return dishes;
    }
}
