package com.robosh.model.dao;

import com.robosh.model.entity.Ingredient;

import java.sql.SQLException;
import java.util.List;

public interface IngredientDao extends Dao<Ingredient> {
    List<Ingredient> selectDishIngredients(long dish_id) throws SQLException;
    void addDishIngredient(long dish_id, long ingredient_id) throws SQLException;
}
