package com.robosh.model.dao.mapper;


import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishMapper implements Mapper<Dish>  {

    @Override
    public Dish extractObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Dish dish = Dish.newBuilder()
                .setId(resultSet.getLong("dish_id"))
                .setName(resultSet.getString("name"))
                .setPrice(resultSet.getFloat("price"))
                .setWeight(resultSet.getShort("weight"))
//                .addIngredient(new IngredientMapper().extractObjectFromResultSet(resultSet))
                .build();

//        while (resultSet.next() && resultSet.getLong("dish_id") == dish.getId()) {
//            dish.addIngredient(new IngredientMapper().extractObjectFromResultSet(resultSet));
//
//        }
//        resultSet.previous();
        return dish;
    }

    public List<Ingredient> extractDishIngredients(ResultSet resultSet) throws SQLException {
        List<Ingredient> ingredientList = new ArrayList<>();
        while (resultSet.next()) {
            ingredientList.add(new IngredientMapper().extractObjectFromResultSet(resultSet));
        }
        return ingredientList;
    }
}
