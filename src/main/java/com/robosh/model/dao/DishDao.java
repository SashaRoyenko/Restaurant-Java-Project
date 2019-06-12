package com.robosh.model.dao;


import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Ingredient;

import java.sql.SQLException;
import java.util.List;

public interface DishDao extends Dao<Dish> {
    void addIngredient(long dish_id, long ingredient_id);
    List<Ingredient> selectDishIngredients(Dish dish);
}
