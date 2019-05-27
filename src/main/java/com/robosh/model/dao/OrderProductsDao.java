package com.robosh.model.dao;

import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderProductsDao extends Dao<OrderProducts> {
    void addDish(Dish dish, OrderProducts orderProducts) throws SQLException;
    void addDrink(Drink drink, OrderProducts orderProducts) throws SQLException;
    void deleteDish(Dish dish, OrderProducts orderProducts) throws SQLException;
    void deleteDrink(Drink drink, OrderProducts orderProducts) throws SQLException;
    List<Drink> selectDrinks(User user) throws SQLException;
    List<Dish> selectDishes(User user) throws SQLException;
}
