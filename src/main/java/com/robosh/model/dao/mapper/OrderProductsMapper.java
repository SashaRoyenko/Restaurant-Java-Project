package com.robosh.model.dao.mapper;

import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderProductsMapper implements Mapper<OrderProducts>{
    @Override
    public OrderProducts extractObjectFromResultSet(ResultSet resultSet) throws SQLException {
        OrderProducts orderProducts = OrderProducts.newBuilder()
                .setId(resultSet.getLong("order_products_id"))
                .setUser(new UserMapper().extractObjectFromResultSet(resultSet))
                .build();
        return orderProducts;
    }

    public List<Dish> extractOrderProductsDishes(ResultSet resultSet) throws SQLException {
        List<Dish> dishList = new ArrayList<>();
        while(resultSet.next()){
            dishList.add(new DishMapper().extractObjectFromResultSet(resultSet));
        }
        return dishList;
    }

    public List<Drink> extractOrderProductsDrinks(ResultSet resultSet) throws SQLException {
        List<Drink> drinkList = new ArrayList<>();
        while(resultSet.next()){
            drinkList.add(new DrinkMapper().extractObjectFromResultSet(resultSet));
        }
        return drinkList;
    }
}
